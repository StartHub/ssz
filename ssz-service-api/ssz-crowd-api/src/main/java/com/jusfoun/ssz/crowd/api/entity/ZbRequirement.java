package com.jusfoun.ssz.crowd.api.entity;

import com.jusfoun.ssz.core.api.model.GenericModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel
public class ZbRequirement extends GenericModel {

    /**
     * 主键
     */
    @ApiModelProperty(value = "主键")
    private Long id;
    /**
     * 用户ID
     */
    @ApiModelProperty(value = "用户ID")
    private String userId;
    /**
     * 需求编号
     */
    @ApiModelProperty(value = "需求编号")
    private String requireSn;
    /**
     * 需求标题
     */
    @ApiModelProperty(value = "需求标题")
    private String title;
    /**
     * 联系人名称
     */
    @ApiModelProperty(value = "联系人名称")
    private String contactName;
    /**
     * 联系人电话
     */
    @ApiModelProperty(value = "联系人电话")
    private String contactPhone;
    /**
     * 0需求关闭1需求登记2需求分析3需求确认
     */
    @ApiModelProperty(value = "0需求关闭1需求登记2需求分析3需求确认")
    private Short status;
    /**
     * 需求类型
     */
    @ApiModelProperty(value = "需求类型")
    private Short type;
    /**
     * 悬赏金额
     */
    @ApiModelProperty(value = "悬赏金额")
    private Long rewardMoney;
    /**
     * 需求描述
     */
    @ApiModelProperty(value = "需求描述")
    private String description;
    /**
     * 需求标签
     */
    @ApiModelProperty(value = "需求标签")
    private String tag;
    /**
     * 托管比例
     */
    @ApiModelProperty(value = "托管比例")
    private Integer trusteePercent;
    /**
     * 交付验收要求
     */
    @ApiModelProperty(value = "交付验收要求")
    private String checkRemark;
    /**
     * 需求发布时间
     */
    @ApiModelProperty(value = "需求发布时间")
    private Date pressTime;
    /**
     * 报名截止时间
     */
    @ApiModelProperty(value = "报名截止时间")
    private Date applyDeadline;
    /**
     * 交付截止时间
     */
    @ApiModelProperty(value = "交付截止时间")
    private Date deliveryDeadline;
    /**
     * 添加时间
     */
    @ApiModelProperty(value = "添加时间")
    private Date addTime;
    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;
    /**
     * 添加人ID
     */
    @ApiModelProperty(value = "添加人ID")
    private String addOperator;
    /**
     * 更新人ID
     */
    @ApiModelProperty(value = "更新人ID")
    private String updateOperator;

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

    public String getRequireSn() {
        return requireSn;
    }

    public void setRequireSn(String requireSn) {
        this.requireSn = requireSn == null ? null : requireSn.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName == null ? null : contactName.trim();
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone == null ? null : contactPhone.trim();
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public Long getRewardMoney() {
        return rewardMoney;
    }

    public void setRewardMoney(Long rewardMoney) {
        this.rewardMoney = rewardMoney;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
    }

    public Integer getTrusteePercent() {
        return trusteePercent;
    }

    public void setTrusteePercent(Integer trusteePercent) {
        this.trusteePercent = trusteePercent;
    }

    public String getCheckRemark() {
        return checkRemark;
    }

    public void setCheckRemark(String checkRemark) {
        this.checkRemark = checkRemark == null ? null : checkRemark.trim();
    }

    public Date getPressTime() {
        return pressTime;
    }

    public void setPressTime(Date pressTime) {
        this.pressTime = pressTime;
    }

    public Date getApplyDeadline() {
        return applyDeadline;
    }

    public void setApplyDeadline(Date applyDeadline) {
        this.applyDeadline = applyDeadline;
    }

    public Date getDeliveryDeadline() {
        return deliveryDeadline;
    }

    public void setDeliveryDeadline(Date deliveryDeadline) {
        this.deliveryDeadline = deliveryDeadline;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getAddOperator() {
        return addOperator;
    }

    public void setAddOperator(String addOperator) {
        this.addOperator = addOperator == null ? null : addOperator.trim();
    }

    public String getUpdateOperator() {
        return updateOperator;
    }

    public void setUpdateOperator(String updateOperator) {
        this.updateOperator = updateOperator == null ? null : updateOperator.trim();
    }
}