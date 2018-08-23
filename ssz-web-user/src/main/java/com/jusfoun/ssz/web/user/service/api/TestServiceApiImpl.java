package com.jusfoun.ssz.web.user.service.api;

import com.jusfoun.ssz.user.api.api.TestServiceApi;
import com.jusfoun.ssz.user.api.dao.UserMapper;
import com.jusfoun.ssz.user.api.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by wangjl on 2018-7-14.
 */
@RestController
public class TestServiceApiImpl implements TestServiceApi {
    @Autowired
    UserMapper userMapper;
    @Override
    public List<User> getAll() {
        return userMapper.selectAll();
    }
}
