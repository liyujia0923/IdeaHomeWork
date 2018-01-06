package com.bdqn.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * Created by 佳 on 2017/12/9.
 */
public class Grade3 {
    private Integer id;
    private String gradeName;
    @JSONField(format = "yyyy-MM-dd")
    private Date createDate;
    private String details;

    @Override
    public String toString() {
        return "Grade3{" +
                "id=" + id +
                ", gradeName='" + gradeName + '\'' +
                ", createDate=" + createDate +
                ", details='" + details + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
