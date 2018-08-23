package com.jusfoun.ssz.mq.service;

/**
 * Desc: Rabbit接口
 * Author: Cheng
 * Date: 2016/4/25 0025
 */
public interface RabbitSmsService {

    /**
     * 发送注册短消息
     * @param msgData
     */
    void sendValidate(Object msgData);

    /**
     * 现金通知
     * @param msgData
     */
    void sendCashNotify(Object msgData);
}
