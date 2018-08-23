package com.jusfoun.ssz.crowd.api.dao;

import com.jusfoun.ssz.core.api.dao.GenericDao;
import com.jusfoun.ssz.crowd.api.entity.ZbAccount;
import org.springframework.data.repository.query.Param;

import java.util.Map;

public interface ZbAccountMapper extends GenericDao<ZbAccount> {

    ZbAccount updateById(@Param("map") Map map);
}