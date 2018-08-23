package com.jusfoun.ssz.user.api.service;

import com.jusfoun.ssz.core.api.service.GenericService;
import com.jusfoun.ssz.user.api.entity.User;

public interface UserService extends GenericService<User, String>{
    Object getInfo(String id);
}