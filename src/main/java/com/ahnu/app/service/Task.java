package com.ahnu.app.service;

import com.ahnu.app.bean.AreaItem;
import com.ahnu.app.bean.FieldItem;
import com.ahnu.app.bean.Item;
import com.ahnu.app.bean.SubmitForm;
import com.ahnu.app.common.ApiConstant;
import com.ahnu.app.common.Beanutils;
import com.ahnu.app.common.EmailConstant;
import com.ahnu.app.common.UserConstant;
import com.ahnu.app.dao.RequestDao;
import com.ahnu.app.dao.SendDao;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 每天被启动的任务
 *
 * @author DamonCheng@ssw.com.au
 * @date 8/6/2020 11:39 AM
 */
public class Task {


    /**
     * 成功
     */
    private static final String SUCCESS = "SUCCESS";

    private static final String RESP_LOGIN_KEY = "WEC-REDIRECTURL";

    /**
     * 开始方法
     */
    public void start() {
        try {
            //需要提交的表单数据
            SubmitForm submitForm = new SubmitForm();
            //查询今日是否有表单可以提交
            JSONObject datas = getFormList();
            //判断是否跳转到登录页面
            if (datas.containsKey(RESP_LOGIN_KEY)) {
                SendDao.send(UserConstant.COOKIE + "\n" + datas, EmailConstant.FAIL + ",登录过期");

            }
            JSONArray formList = datas.getJSONArray("rows");
            if (formList == null) {
                return;
            }
            for (int i = 0; i < formList.size(); i++) {
                JSONObject jsonRow = formList.getJSONObject(i);
                Integer isHandled = jsonRow.getInteger("isHandled");
                //查看是否已经提交
                if (!isHandled.equals(0)) {
                    continue;
                }
                //这个 wid =collectorWid;
                String wid = jsonRow.getString("wid");
                String formWid = jsonRow.getString("formWid");
                submitForm.setFormWid(formWid);
                submitForm.setAddress("");
                submitForm.setCollectWid(wid);
                String schoolTaskWid = getSchoolTaskWid(wid);
                submitForm.setSchoolTaskWid(schoolTaskWid);
                List<Item> form = getForm(formWid, wid);
                if (form.size() != 3) {
                    SendDao.send(EmailConstant.FAIL + ",今天可能有多个表单", "提交失败");
                    continue;
                }
                submitForm.setForm(form);
                if (submit(submitForm)) {
                    SendDao.send("提交成功", EmailConstant.SUCCESS);

                    return;
                } else {
                    SendDao.send("提交失败:" + JSON.toJSONString(submitForm), EmailConstant.FAIL);
                    return;
                }

            }

        } catch (Exception ex) {
            SendDao.send(EmailConstant.FAIL + ",异常信息：" + ex.getMessage(), "出现异常");
        }


    }

    /**
     * 获取今日最新未填写的表单集合
     *
     * @return 表单信息
     * @throws IOException
     */
    public JSONObject getFormList() {
        return RequestDao.request(UserConstant.DOMAIN + ApiConstant.FORMLIST, "{\"pageSize\":6,\"pageNumber\":1}").getJSONObject("datas");
    }


    /**
     * 传入collectorWid 获取schoolTaskWid
     *
     * @param collectorWid 就是表单的Wid
     * @return
     */
    public String getSchoolTaskWid(String collectorWid) {
        return RequestDao.request(UserConstant.DOMAIN + ApiConstant.SCHOOLTASKWID, "{\"collectorWid\":\"" + collectorWid + "\"}").getJSONObject("datas").getJSONObject("collector").getString("schoolTaskWid");
    }


    /**
     * 获取表单，并填写表单
     *
     * @param formWid
     * @param collectorWid 就是表单的Wid
     * @return 返回已经填写好的表单
     */
    public List<Item> getForm(String formWid, String collectorWid) {
        JSONArray jsonArray = RequestDao.request(UserConstant.DOMAIN + ApiConstant.FORMDETAIl, "{\"pageSize\":20,\"pageNumber\":1,\"formWid\":\"" + formWid + "\",\"collectorWid\":\"" + collectorWid + "\"}").getJSONObject("datas").getJSONArray("rows");
        List<Item> form = new ArrayList<Item>(4);
        for (int j = 0; j < jsonArray.size(); j++) {
            Item item = jsonArray.getObject(j, Item.class);
            //第一个input
            if ("1".equals(item.getSort())) {
                AreaItem areaItem = new AreaItem();
                Beanutils.copyProperties(item, areaItem);
                areaItem.setFormWid(formWid);
                areaItem.setValue("浙江省/杭州市/下城区");
                areaItem.setArea1("浙江省");
                areaItem.setArea2("杭州市");
                areaItem.setArea3("下城区");
                form.add(areaItem);
                //第二个input
            } else if ("2".equals(item.getSort())) {
                item.setFormWid(formWid);
                item.setValue("在实习或工作单位");
                List<FieldItem> fieldItems = new ArrayList<FieldItem>();
                for (FieldItem fieldItem : item.getFieldItems()) {
                    if (fieldItem.getContent().equals("在实习或工作单位")) {
                        fieldItem.setIsSelected(null);
                        fieldItems.add(fieldItem);
                    }
                }
                item.setFieldItems(fieldItems);
                form.add(item);
                //第三个input
            } else if ("3".equals(item.getSort())) {
                item.setFormWid(formWid);
                List<FieldItem> fieldItems = new ArrayList<FieldItem>();
                for (FieldItem fieldItem : item.getFieldItems()) {
                    if (fieldItem.getContent().equals("健康")) {
                        fieldItem.setIsSelected(null);
                        fieldItems.add(fieldItem);
                    }
                }
                item.setFieldItems(fieldItems);
                form.add(item);
            }

        }
        System.out.println(JSON.toJSONString(form));
        return form;
    }

    /**
     * 提交信息
     *
     * @param submitForm 表单信息
     * @return
     */
    public boolean submit(SubmitForm submitForm) {
        JSONObject request = RequestDao.request(UserConstant.DOMAIN + ApiConstant.SUBMITFORM, JSONObject.toJSONString(submitForm, SerializerFeature.WriteMapNullValue));
        String message = request.getString("message");
        if (message == null || !SUCCESS.equals(message)) {
            return false;
        } else {
            return true;
        }
    }

    public static void stop(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
