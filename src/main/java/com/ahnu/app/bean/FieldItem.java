package com.ahnu.app.bean;

/**
 * 构造表单参数
 * @author DamonCheng@ssw.com.au
 * @date 8/5/2020 2:48 PM
 */
public class FieldItem {
    private String itemWid;
    private String content;
    private Integer isOtherItems;
    private String contendExtend;
    private Integer isSelected;

    public String getItemWid() {
        return itemWid;
    }

    public void setItemWid(String itemWid) {
        this.itemWid = itemWid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getIsOtherItems() {
        return isOtherItems;
    }

    public void setIsOtherItems(Integer isOtherItems) {
        this.isOtherItems = isOtherItems;
    }

    public String getContendExtend() {
        return contendExtend;
    }

    public void setContendExtend(String contendExtend) {
        this.contendExtend = contendExtend;
    }

    public Integer getIsSelected() {
        return isSelected;
    }

    public void setIsSelected(Integer isSelected) {
        this.isSelected = isSelected;
    }
}
