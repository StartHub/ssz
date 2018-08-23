package com.jusfoun.ssz.web.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ${DESCRIPTION}
 *
 * @author : dengxu
 * @create 2018-08-06 17:12
 **/
@RestController
public class IndexController {

    @RequestMapping("/")
    public String index(){
        return "hello user!!!";
    }
}
