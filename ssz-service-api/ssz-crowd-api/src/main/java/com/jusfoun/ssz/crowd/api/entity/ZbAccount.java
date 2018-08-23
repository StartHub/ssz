package com.jusfoun.ssz.crowd.api.entity;

import com.jusfoun.ssz.core.api.model.GenericModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel
public class ZbAccount extends GenericModel {

    @ApiModelProperty(value="")
    private Integer id;
    @ApiModelProperty(value="")
    private Integer userId;
    @ApiModelProperty(value="")
    private Long money;
    @ApiModelProperty(value="")
    private Date updateTime;
    @ApiModelProperty(value="")
    private Date addTime;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public Long getMoney() {
        return money;
    }
    public void setMoney(Long money) {
        this.money = money;
    }
    public Date getUpdateTime() {
        return updateTime;
    }
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    public Date getAddTime() {
        return addTime;
    }
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}