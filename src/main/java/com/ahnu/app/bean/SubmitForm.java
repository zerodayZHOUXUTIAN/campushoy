package com.ahnu.app.bean;

import java.util.List;

/**
 * 用于提交表单信息的Bean
 *
 * @author DamonCheng@ssw.com.au
 * @date 8/5/2020 2:23 PM
 */
public class SubmitForm {
    private String formWid;
    private String address;
    private String collectWid;
    private String schoolTaskWid;
    private List<Item> form;

    public String getFormWid() {
        return formWid;
    }

    public void setFormWid(String formWid) {
        this.formWid = formWid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCollectWid() {
        return collectWid;
    }

    public void setCollectWid(String collectWid) {
        this.collectWid = collectWid;
    }

    public String getSchoolTaskWid() {
        return schoolTaskWid;
    }

    public void setSchoolTaskWid(String schoolTaskWid) {
        this.schoolTaskWid = schoolTaskWid;
    }

    public List<Item> getForm() {
        return form;
    }

    public void setForm(List<Item> form) {
        this.form = form;
    }
}
