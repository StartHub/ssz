package com.jusfoun.ssz.crowd.api.entity;

import com.jusfoun.ssz.core.api.model.GenericModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel
public class ZbAnnex extends GenericModel {

    /**
     * 主键
     */
    @ApiModelProperty(value = "主键")
    private Long id;
    /**
     * 关联ID（需求表id或方案id）
     */
    @ApiModelProperty(value = "关联ID（需求表id或方案id）")
    private Long contactId;
    /**
     * 0：需求表附件（需求方，1：方案表附件（服务方,2：需求分析附件（运营方
     */
    @ApiModelProperty(value = "0：需求表附件（需求方，1：方案表附件（服务方,2：需求分析附件（运营方")
    private Short fileType;
    /** 文件名 */
    @ApiModelProperty(value= "文件名")
    private String fileName;
    /**
     * 文件路径
     */
    @ApiModelProperty(value = "文件路径")
    private String filePath;
    /**
     * 0：待审核，1：通过，2：驳回（暂保留）
     */
    @ApiModelProperty(value = "0：待审核，1：通过，2：驳回（暂保留）")
    private Short status;
    /** 附言 */
    @ApiModelProperty(value = "附言")
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

    public Short getFileType() {
        return fileType;
    }

    public void setFileType(Short fileType) {
        this.fileType = fileType;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath == null ? null : filePath.trim();
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
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