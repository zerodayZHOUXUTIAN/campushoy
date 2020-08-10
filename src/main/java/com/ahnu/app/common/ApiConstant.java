package com.ahnu.app.common;

/**
 * 需要访问的接口地址
 *
 * @author DamonCheng@ssw.com.au
 * @date 8/4/2020 5:13 PM
 */
public interface ApiConstant {


    /**
     * 获取今日最新未填写的表单集合
     */
    String FORMLIST = "/wec-counselor-collector-apps/stu/collector/queryCollectorProcessingList";

    /**
     * 获取学校表单号
     */
    String SCHOOLTASKWID = "/wec-counselor-collector-apps/stu/collector/detailCollector";

    /**
     * 获取表单的详细信息
     */
    String FORMDETAIl = "/wec-counselor-collector-apps/stu/collector/getFormFields";

    /**
     * 提交表单接口
     */
    String SUBMITFORM = "/wec-counselor-collector-apps/stu/collector/submitForm";


}
