package com.sylvanas.user.config;

import lombok.Data;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Data
@Configuration
//@ConfigurationProperties(prefix = "rocketmq.producer.sample")
public class SampleProducerConfig {
//    @Value("${rocketmq.producer.sample.groupName}")
    private String groupName="ProducerGroup";
//    @Value("${rocketmq.producer.sample.namesrvAddr}")
    private String namesrvAddr="127.0.0.1:9876";
//    @Value("${rocketmq.producer.sample.instanceName}")
    private String instanceName="ProducerGroup";
//    @Value("${rocketmq.producer.sample.maxMessageSize}")
    private int maxMessageSize=131072;
//    @Value("${rocketmq.producer.sample.sendMsgTimeout}")
    private int sendMsgTimeout=10000;

    @Bean(destroyMethod = "shutdown")
    public DefaultMQProducer sampleProducer() throws MQClientException {
        DefaultMQProducer producer = new DefaultMQProducer(groupName);
        producer.setNamesrvAddr(namesrvAddr);
        producer.setInstanceName(instanceName);
        producer.setMaxMessageSize(maxMessageSize);
        producer.setSendMsgTimeout(sendMsgTimeout);
        producer.setVipChannelEnabled(false);
        producer.start();
        System.out.println("================>生产者配置完成，ProducerGroupName{}<================"+groupName);
        return producer;
    }

}
