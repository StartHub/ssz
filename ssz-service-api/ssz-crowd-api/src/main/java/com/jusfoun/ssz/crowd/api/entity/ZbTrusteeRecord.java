package com.jusfoun.ssz.crowd.api.entity;

import com.jusfoun.ssz.core.api.model.GenericModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel
public class ZbTrusteeRecord extends GenericModel {

	/** 主键 */
    @ApiModelProperty(value="主键")
    private Long id;
	/** 用户id */
    @ApiModelProperty(value="用户id")
    private String userId;
	/** 需求id */
    @ApiModelProperty(value="需求id")
    private Long requirementId;
	/** 悬赏金额 */
    @ApiModelProperty(value="悬赏金额")
    private Long rewardMoney;
	/** 托管比例 */
    @ApiModelProperty(value="托管比例")
    private Integer trusteePercent;
	/** 本次托管金额 */
    @ApiModelProperty(value="本次托管金额")
    private Long actualMoney;
	/** 托管次数 */
    @ApiModelProperty(value="托管次数")
    private Integer trusteeNum;
	/** 流水号 */
    @ApiModelProperty(value="流水号")
    private String serialNo;
	/** 0初始1成功2失败 */
    @ApiModelProperty(value="0初始1成功2失败")
    private Short status;
	/** 添加时间 */
    @ApiModelProperty(value="添加时间")
    private Date addTime;
    @ApiModelProperty(value="")
    private String operator;
    @ApiModelProperty(value="")
    private Date updateTime;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }
    public Long getRequirementId() {
        return requirementId;
    }
    public void setRequirementId(Long requirementId) {
        this.requirementId = requirementId;
    }
    public Long getRewardMoney() {
        return rewardMoney;
    }
    public void setRewardMoney(Long rewardMoney) {
        this.rewardMoney = rewardMoney;
    }
    public Integer getTrusteePercent() {
        return trusteePercent;
    }
    public void setTrusteePercent(Integer trusteePercent) {
        this.trusteePercent = trusteePercent;
    }
    public Long getActualMoney() {
        return actualMoney;
    }
    public void setActualMoney(Long actualMoney) {
        this.actualMoney = actualMoney;
    }
    public Integer getTrusteeNum() {
        return trusteeNum;
    }
    public void setTrusteeNum(Integer trusteeNum) {
        this.trusteeNum = trusteeNum;
    }
    public String getSerialNo() {
        return serialNo;
    }
    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo == null ? null : serialNo.trim();
    }
    public Short getStatus() {
        return status;
    }
    public void setStatus(Short status) {
        this.status = status;
    }
    public Date getAddTime() {
        return addTime;
    }
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
    public String getOperator() {
        return operator;
    }
    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }
    public Date getUpdateTime() {
        return updateTime;
    }
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}