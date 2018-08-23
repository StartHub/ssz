package com.jusfoun.ssz.crowd.api.dao;

import com.jusfoun.ssz.core.api.dao.GenericDao;
import com.jusfoun.ssz.crowd.api.entity.ZbAnnex;

public interface ZbAnnexMapper extends GenericDao<ZbAnnex> {
    int deleteByPrimaryKey(Long id);

    int insert(ZbAnnex record);

    int insertSelective(ZbAnnex record);

    ZbAnnex selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ZbAnnex record);

    int updateByPrimaryKey(ZbAnnex record);
}