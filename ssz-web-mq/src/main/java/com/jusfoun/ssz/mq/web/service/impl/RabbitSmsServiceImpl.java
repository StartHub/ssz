package com.jusfoun.ssz.mq.web.service.impl;

import com.jusfoun.ssz.mq.service.RabbitSmsService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.jusfoun.ssz.mq.model.constant.QueueName.*;


/**
 * Desc: 消息列队
 * Author: Cheng
 * Date: 2016/4/25 0025
 */
@RestController
public class RabbitSmsServiceImpl implements RabbitSmsService {
    @Autowired
    private RabbitTemplate rabbitSmsTemplate;

    @RequestMapping("send")
    @Override
    public void sendValidate(Object data) {
        rabbitSmsTemplate.convertAndSend(EXCHANGE, VALIDATE, data);
    }

    @RequestMapping("send2")
    @Override
    public void sendCashNotify(Object data) {
        rabbitSmsTemplate.convertAndSend(EXCHANGE, NOTICE, data);
    }
}
