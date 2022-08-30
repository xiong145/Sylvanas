package com.sylvanas.user.controller;


import com.alibaba.cloud.commons.lang.StringUtils;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;
import java.text.SimpleDateFormat;
import java.util.Date;
@RestController
@RequestMapping("user")
public class SendController {
    @Resource
    DefaultMQProducer sampleProducer;

    @RequestMapping("sendMsg")
    public String sendMsg(@PathParam("topic") String topic){
        if(StringUtils.isBlank(topic)){
            return "param topic is must not null !";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String body = "hi, 普通消息, 时间::" + sdf.format(new Date());
//        MsgEntity msgEntity = MsgEntity.builder().userId(111).orderId(222).build();
        Message message = new Message(topic, "test", "keys", body.getBytes());
        SendResult sendResult = null;
        try {
            //同步发送消息
            sendResult = sampleProducer.send(message);
            System.out.println(sendResult.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "sendMsg succ";
    }

}
