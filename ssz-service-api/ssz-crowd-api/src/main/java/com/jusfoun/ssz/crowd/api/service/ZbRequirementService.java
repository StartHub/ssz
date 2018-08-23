package com.jusfoun.ssz.crowd.api.service;

import com.jusfoun.ssz.core.utils.ReturnData;
import com.jusfoun.ssz.crowd.api.vo.ZbRequirementVo;

/**
 * ${DESCRIPTION}
 *
 * @author : dengxu
 * @create 2018-07-18 15:24
 **/
public interface ZbRequirementService {

    ReturnData insertRequirement(ZbRequirementVo vo);

    ReturnData selectById(Long id);
}
