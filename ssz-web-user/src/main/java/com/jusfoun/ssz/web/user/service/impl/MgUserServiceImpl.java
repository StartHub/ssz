package com.jusfoun.ssz.web.user.service.impl;

import com.jusfoun.ssz.core.service.impl.GenericMongoServiceImpl;
import com.jusfoun.ssz.user.api.entity.User;
import com.jusfoun.ssz.user.api.service.MgUserService;
import org.springframework.stereotype.Service;

/**
 * Created by wangjl on 2018-7-13.
 */
@Service
public class MgUserServiceImpl extends GenericMongoServiceImpl<User, String> implements MgUserService {
}
