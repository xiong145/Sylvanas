package com.sylvanas.user.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sylvanas.user.Bo.MessageBo;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author xiong
 */
@RestController
@RequestMapping(value = "/kafka")
public class KafkaSenderController {


    private final KafkaTemplate<String, String> kafkaTemplate;

    //构造器方式注入  kafkaTemplate
    public KafkaSenderController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    private Gson gson = new GsonBuilder().create();

    @RequestMapping(value = "kafkaSend")
    public void send(String msg) {
        MessageBo message = new MessageBo();
// 创建一个 StopWatch 实例
        StopWatch sw = new StopWatch("耗时计算");
// 开始计时
        sw.start("任务1");

        message.setId(System.currentTimeMillis());
        message.setMsg(msg);
        message.setSendTime(new Date());
        System.out.println("【++++++++++++++++++ message ：{}】" + gson.toJson(message));
        //对 topic =  hello2 的发送消息
        kafkaTemplate.send("hello2", gson.toJson(message));
        sw.stop();
        System.out.println(sw.getTotalTimeMillis());
    }
}
