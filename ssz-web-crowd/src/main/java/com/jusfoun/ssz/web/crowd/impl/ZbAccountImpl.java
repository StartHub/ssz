package com.jusfoun.ssz.web.crowd.impl;

import com.jusfoun.ssz.core.service.impl.GenericServiceImpl;
import com.jusfoun.ssz.crowd.api.dao.ZbAccountMapper;
import com.jusfoun.ssz.crowd.api.entity.ZbAccount;
import com.jusfoun.ssz.crowd.api.service.ZbAccountService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * ${DESCRIPTION}
 *
 * @author : dengxu
 * @create 2018-08-06 11:27
 **/
public class ZbAccountImpl extends GenericServiceImpl<ZbAccount, Integer> implements ZbAccountService {

    @Autowired
    private ZbAccountMapper zbAccountMapper;

    @Autowired
    public void setDao(ZbAccountMapper zbAccountMapper) {
        super.setDao(zbAccountMapper);
    }


    @Override
    public ZbAccount updateById(Map map) {
        return zbAccountMapper.updateById(map);
    }
}
