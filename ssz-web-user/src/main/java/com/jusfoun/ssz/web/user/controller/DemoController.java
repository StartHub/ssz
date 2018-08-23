package com.jusfoun.ssz.web.user.controller;

import com.jusfoun.ssz.core.redis.RedisService;
import com.jusfoun.ssz.core.utils.ReturnData;
import com.jusfoun.ssz.user.api.dao.UserMapper;
import com.jusfoun.ssz.user.api.entity.User;
import com.jusfoun.ssz.user.api.service.MgUserService;
import com.jusfoun.ssz.user.api.service.UserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by wangjl on 2018-7-13.
 */
@Api(value="用户controller",tags={"用户操作接口"})
@RestController
@RequestMapping("user")
public class DemoController {
    @Autowired
    UserService userService;
    @Autowired
    MgUserService mgUserService;
    @Autowired
    UserMapper userMapper;
    @Autowired
    RedisService redisService;

    @ApiOperation(value="获取用户信息", notes="根据id获取用户信息")// 使用该注解描述接口方法信息
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "id", value = "用户Id", required = true, dataType = "String", paramType="path")
//    })// 使用该注解描述方法参数信息，此处需要注意的是paramType参数，需要配置成path，否则在UI中访问接口方法时，会报错
    @GetMapping("info")
    public ReturnData getInfo(@ApiParam(name="id",value="用户id",required=true) String id) {
        return ReturnData.success(userService.getInfo(id));
    }

    @GetMapping("info/all")
    public ReturnData getAll(@ApiParam @RequestBody User user) {
        return ReturnData.success(userService.selectList());
    }


    @PostMapping("info")
    public ReturnData addUser() {
        User user = new User();
        user.setName("kkk");
        user.setRemark("了看两手空空辅导费");
        user.setSex(1);
        return ReturnData.success(userService.insert(user));
    }

    @PutMapping("info")
    public ReturnData updateUser() {
        User user = new User();
        user.setName("大大大大大");
        user.setId("1");
        return ReturnData.success(userService.updateByIdSelective(user));
    }

    @DeleteMapping("info")
    public ReturnData deleteUser(String id) {
        return ReturnData.success(userService.delete(id));
    }
}
