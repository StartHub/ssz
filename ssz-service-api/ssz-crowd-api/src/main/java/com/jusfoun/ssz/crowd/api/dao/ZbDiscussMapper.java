package com.jusfoun.ssz.crowd.api.dao;

import com.jusfoun.ssz.core.api.dao.GenericDao;
import com.jusfoun.ssz.crowd.api.entity.ZbDiscuss;

public interface ZbDiscussMapper extends GenericDao<ZbDiscuss> {
    int deleteByPrimaryKey(Long id);

    int insert(ZbDiscuss record);

    int insertSelective(ZbDiscuss record);

    ZbDiscuss selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ZbDiscuss record);

    int updateByPrimaryKey(ZbDiscuss record);
}