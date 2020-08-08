package com.ahnu.app.bean;

import java.util.List;

/**
 * 构造表单参数
 *
 * @author DamonCheng@ssw.com.au
 * @date 8/6/2020 9:38 AM
 */
public class Item {
    private String wid;
    private String formWid;
    private Integer fieldType;
    private String title;
    private String description;
    private Integer minLength;
    private String sort;
    private Integer maxLength;
    private Integer isRequired;
    private Integer imageCount;
    private Integer hasOtherItems;
    private String colName;
    private String value;
    private Integer minValue;
    private Integer maxValue;
    private Boolean isDecimal;
    private List<FieldItem> fieldItems;

    public String getWid() {
        return wid;
    }

    public void setWid(String wid) {
        this.wid = wid;
    }

    public String getFormWid() {
        return formWid;
    }

    public void setFormWid(String formWid) {
        this.formWid = formWid;
    }

    public Integer getFieldType() {
        return fieldType;
    }

    public void setFieldType(Integer fieldType) {
        this.fieldType = fieldType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getMinLength() {
        return minLength;
    }

    public void setMinLength(Integer minLength) {
        this.minLength = minLength;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public Integer getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(Integer maxLength) {
        this.maxLength = maxLength;
    }

    public Integer getIsRequired() {
        return isRequired;
    }

    public void setIsRequired(Integer isRequired) {
        this.isRequired = isRequired;
    }

    public Integer getImageCount() {
        return imageCount;
    }

    public void setImageCount(Integer imageCount) {
        this.imageCount = imageCount;
    }

    public Integer getHasOtherItems() {
        return hasOtherItems;
    }

    public void setHasOtherItems(Integer hasOtherItems) {
        this.hasOtherItems = hasOtherItems;
    }

    public String getColName() {
        return colName;
    }

    public void setColName(String colName) {
        this.colName = colName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getMinValue() {
        return minValue;
    }

    public void setMinValue(Integer minValue) {
        this.minValue = minValue;
    }

    public Integer getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(Integer maxValue) {
        this.maxValue = maxValue;
    }

    public Boolean getIsDecimal() {
        return isDecimal;
    }

    public void setIsDecimal(Boolean decimal) {
        isDecimal = decimal;
    }

    public List<FieldItem> getFieldItems() {
        return fieldItems;
    }

    public void setFieldItems(List<FieldItem> fieldItems) {
        this.fieldItems = fieldItems;
    }
}
