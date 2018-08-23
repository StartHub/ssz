package com.jusfoun.ssz.mq.web;

import com.alibaba.fastjson.JSON;
import com.jusfoun.ssz.mq.model.model.SmsModel;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static com.jusfoun.ssz.mq.model.constant.QueueName.VALIDATE;

/**
 * Desc:
 * Author: hp
 * Date: 2017/10/10
 */
@Component
@RabbitListener(queues = VALIDATE)
public class Receiver {

    @RabbitListener(queues = VALIDATE)
    @RabbitHandler
    public void process(SmsModel message) {
        System.out.println("Receiver : " + JSON.toJSONString(message));
    }
}
