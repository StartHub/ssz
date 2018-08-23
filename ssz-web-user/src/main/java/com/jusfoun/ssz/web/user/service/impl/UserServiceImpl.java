package com.jusfoun.ssz.web.user.service.impl;

import com.jusfoun.ssz.core.redis.RedisService;
import com.jusfoun.ssz.core.service.impl.GenericServiceImpl;
import com.jusfoun.ssz.user.api.dao.UserMapper;
import com.jusfoun.ssz.user.api.entity.User;
import com.jusfoun.ssz.user.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Desc: 购物车
 * Author: cheng
 * Date: 2016/6/28
 */
@Service
public class UserServiceImpl extends GenericServiceImpl<User, String> implements UserService  {

    @Autowired
    private RedisService redisService;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    public void setDao(UserMapper userMapper) {
        super.setDao(userMapper);
    }

    @Override
    public Object getInfo(String id) {
//        redisService.set(id, "aabbcc" + id, 0);
//        redisService.get(id);
//        return redisService.get(id);
        return super.selectById(id);
    }
}
