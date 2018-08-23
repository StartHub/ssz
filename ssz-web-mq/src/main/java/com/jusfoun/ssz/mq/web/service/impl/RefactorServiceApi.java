package com.jusfoun.ssz.mq.web.service.impl;

import com.jusfoun.ssz.user.api.api.TestServiceApi;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * Created by wangjl on 2018-7-14.
 */
@FeignClient("user-service")
public interface RefactorServiceApi extends TestServiceApi {

}
