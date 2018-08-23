package com.jusfoun.ssz.mq.web.controller;

import com.jusfoun.ssz.mq.web.service.impl.RefactorServiceApi;
import com.jusfoun.ssz.user.api.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by wangjl on 2018-7-14.
 */
@RestController
@RequestMapping("test")
public class DemoController {
    @Autowired
    RefactorServiceApi testService;
    @GetMapping("t")
    public List<User> test() {
        return testService.getAll();
    }
}
