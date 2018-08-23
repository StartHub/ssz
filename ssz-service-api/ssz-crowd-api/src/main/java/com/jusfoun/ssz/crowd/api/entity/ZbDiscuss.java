package com.jusfoun.ssz.crowd.api.entity;

import com.jusfoun.ssz.core.api.model.GenericModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel
public class ZbDiscuss extends GenericModel {

    /**
     * 主键
     */
    @ApiModelProperty(value = "主键")
    private Long id;
    /**
     * 关联需求ID
     */
    @ApiModelProperty(value="关联需求ID")
    private Long contactId;
    /**
     * 1需求方2运营方
     */
    @ApiModelProperty(value= "1需求方2运营方")
    private Short type;
    /**
     * 沟通建议
     */
    @ApiModelProperty(value = "沟通建议")
    private String desc;
    /** 添加时间 */
    @ApiModelProperty(value="添加时间")
    private Date addTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}