package com.jusfoun.ssz.user.api.dao;

import com.jusfoun.ssz.core.api.dao.GenericDao;
import com.jusfoun.ssz.user.api.entity.User;

public interface UserMapper extends GenericDao<User> {
    String getTest();
}