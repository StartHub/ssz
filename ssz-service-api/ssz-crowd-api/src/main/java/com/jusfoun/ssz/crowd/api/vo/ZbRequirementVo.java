package com.jusfoun.ssz.crowd.api.vo;


import com.jusfoun.ssz.crowd.api.entity.ZbAnnex;
import com.jusfoun.ssz.crowd.api.entity.ZbRequirement;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "需求登记VO")
public class ZbRequirementVo implements Serializable {

    @ApiModelProperty(value = "需求部分", name = "zbRequirement")
    private ZbRequirement zbRequirement;

    private Double amount;

    private List<ZbAnnex> annex;

    public ZbRequirement getZbRequirement() {
        return zbRequirement;
    }

    public void setZbRequirement(ZbRequirement zbRequirement) {
        this.zbRequirement = zbRequirement;
    }

    public List<ZbAnnex> getAnnex() {
        return annex;
    }

    public void setAnnex(List<ZbAnnex> annex) {
        this.annex = annex;
    }

    @ApiModelProperty(value = "金额", name = "amount", example = "1000.00")
    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
