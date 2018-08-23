package com.jusfoun.ssz.user.api.api;

import com.jusfoun.ssz.user.api.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by wangjl on 2018-7-14.
 */
@RequestMapping("test")
public interface TestServiceApi {
    @RequestMapping(value = "getAll", method = RequestMethod.GET)
    List<User> getAll();
}
