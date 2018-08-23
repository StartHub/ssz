package com.jusfoun.ssz.web.crowd.impl;

import com.jusfoun.ssz.core.service.impl.GenericServiceImpl;
import com.jusfoun.ssz.core.utils.ReturnData;
import com.jusfoun.ssz.crowd.api.dao.ZbRequirementMapper;
import com.jusfoun.ssz.crowd.api.entity.ZbRequirement;
import com.jusfoun.ssz.crowd.api.service.ZbRequirementService;
import com.jusfoun.ssz.crowd.api.vo.ZbRequirementVo;
import com.jusfoun.ssz.web.crowd.contants.ZbContants;
import com.jusfoun.ssz.web.crowd.util.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * ${DESCRIPTION}
 *
 * @author : dengxu
 * @create 2018-07-18 15:25
 **/

@Service
public class ZbRequirementServiceImpl extends GenericServiceImpl<ZbRequirement, String> implements ZbRequirementService {

    @Autowired
    private ZbRequirementMapper zbRequirementMapper;

    @Autowired
    public void setDao(ZbRequirementMapper zbRequirementMapper) {
        super.setDao(zbRequirementMapper);
    }


    @Override
    public ReturnData insertRequirement(ZbRequirementVo vo) {

        if (vo.getZbRequirement() != null) {
            ZbRequirement ment = vo.getZbRequirement();
            if (ment.getId() == null) {
                ment.setStatus(Short.parseShort(ZbContants.Zb_Require_Status.REGISTER.code.toString()));
                ment.setAddOperator(vo.getZbRequirement().getUserId());
                ment.setAddTime(new Date());
                ment.setRewardMoney(Math.round(Double.valueOf(vo.getAmount()) * 100));
                ment.setTrusteePercent(30);
                if (vo.getZbRequirement().getType() != null){
                    ment.setRequireSn(CommonUtils.getRequireSn("ZB", vo.getZbRequirement().getType().toString()));
                }
                zbRequirementMapper.insertAndGetId(ment);
                //mongo中添加需求发布时间
//                mgZbRequireStatusService.setRequireStatusInfo(ment.getRequireSn(), ZbContants.ADDTIME, DateUtil.getSimpleDate(ment.getAddTime()));

//                if (com.jusfoun.ssz.crowd.com.jusfoun.ssz.crowd.api.api.vo.getAnnex().size() > 0) {
//                    for (ZbAnnex zbAnnex : com.jusfoun.ssz.crowd.com.jusfoun.ssz.crowd.api.api.vo.getAnnex()) {
//                        zbAnnex.setCorrelationId(ment.getId());
//                        zbAnnex.setAddTime(new Date());
//                        zbAnnex.setType(Short.parseShort("0"));
//                        zbAnnexService.insert(zbAnnex);
//                    }
//                }
            } else {
//                ZbRequirement zbRequirement = zbRequirementMapper.selectByPrimaryKey(ment.getId());
//                if (zbRequirement != null) {
//                    if (zbRequirement.getStatus() == ZbContants.Zb_Require_Status.CHECK_NOT.getCode().shortValue()) {
//                        ment.setStatus(ZbContants.Zb_Require_Status.CHECK_NOT.getCode().shortValue());
//                    }
//                    ment.setRequireSn(zbRequirement.getRequireSn());
//                    ment.setAddTime(zbRequirement.getAddTime());
//                    ment.setAddOperator(zbRequirement.getAddOperator());
//                    ment.setUpdateTime(new Date());
//                    ment.setAmount(Math.round(Double.valueOf(com.jusfoun.ssz.crowd.com.jusfoun.ssz.crowd.api.api.vo.getAmount()) * 100));
//                    ment.setTrusteePercent(zbRequirement.getTrusteePercent());
                if (vo.getAmount() != null) {
                    ment.setRewardMoney(Math.round(Double.valueOf(vo.getAmount()) * 100));
                }
                    ment.setUpdateTime(new Date());
                zbRequirementMapper.updateByIdSelective(ment);

//                    List<Condition> filter = new ArrayList<>();
//                    filter.add(Condition.eq("correlationId", ment.getId()));
//                    zbAnnexService.deleteByCondtion(filter);
//                    if (com.jusfoun.ssz.crowd.com.jusfoun.ssz.crowd.api.api.vo.getAnnex() != null) {
//                        if (com.jusfoun.ssz.crowd.com.jusfoun.ssz.crowd.api.api.vo.getAnnex().size() > 0) {
//                            for (ZbAnnex zbAnnex : com.jusfoun.ssz.crowd.com.jusfoun.ssz.crowd.api.api.vo.getAnnex()) {
//                                zbAnnex.setCorrelationId(ment.getId());
//                                zbAnnex.setAddTime(new Date());
//                                zbAnnex.setType(Short.parseShort("0"));
//                                zbAnnexService.insert(zbAnnex);
//                            }
//                        }
//                    }
//                }
            }
            return ReturnData.success();
        } else {
            return ReturnData.error("需求数据不能为空！！！");
        }
    }

    @Override
    public ReturnData selectById(Long id) {

        ZbRequirement zbRequirement = zbRequirementMapper.selectById(id);
        if(zbRequirement != null){
            return ReturnData.success(zbRequirement);
        }else {
            return ReturnData.error("未查询到该数据！！！");
        }
    }
}
