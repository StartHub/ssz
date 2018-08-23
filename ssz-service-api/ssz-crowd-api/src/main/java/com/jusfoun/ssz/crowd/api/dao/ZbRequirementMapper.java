package com.jusfoun.ssz.crowd.api.dao;

import com.jusfoun.ssz.core.api.dao.GenericDao;
import com.jusfoun.ssz.crowd.api.entity.ZbRequirement;
import org.springframework.data.repository.query.Param;

public interface ZbRequirementMapper extends GenericDao<ZbRequirement> {

    ZbRequirement selectById(@Param("id") Long id);

    int insertAndGetId(ZbRequirement zbRequirement);

    int updateByIdSelective(@Param("zbRequirement") ZbRequirement zbRequirement);
}