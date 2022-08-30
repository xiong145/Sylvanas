package consumer.config;

import consumer.service.ConsumerListener;
import lombok.Data;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.rebalance.AllocateMessageQueueAveragely;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * @author xiong
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "rocketmq.consumer.sample")
public class SampleConsumerConfig {
    /**
     * 消费者分组名称
     */
    private String groupName="ProducerGroup";
    /**
     * 链接地址
     */
    private String namesrvAddr="127.0.0.1:9876";
    /**
     * 单个topic
     */
    private String topic="topic2022";
    /**
     * 单个tag
     */
    private String tag="test";
    /**
     * 消费者最小线程数
     */
    private Integer consumeThreadMin= 5;
    /**
     * 消费者最大线程数
     */
    private Integer consumeThreadMax=32;
    /**
     * 每一批次拉取的最大数量
     */
    private Integer consumeMessageBatchMaxSize=1;

    /**
     * mq 消费者配置
     *
     * @return
     * @throws MQClientException
     */
//    @Bean(initMethod = "start", destroyMethod = "shutdown")
    @Bean(destroyMethod = "shutdown")
    public DefaultMQPushConsumer sampleConsumerGroup() throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(groupName);
        consumer.setInstanceName(groupName);
        consumer.setNamesrvAddr(namesrvAddr);
        consumer.setConsumeThreadMin(consumeThreadMin);
        consumer.setConsumeThreadMax(consumeThreadMax);
        consumer.setConsumeMessageBatchMaxSize(consumeMessageBatchMaxSize);
        consumer.setAllocateMessageQueueStrategy(new AllocateMessageQueueAveragely());
        /**
         * 设置consumer第一次启动是从队列头部开始还是队列尾部开始
         * 如果不是第一次启动，那么按照上次消费的位置继续消费
         */
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_LAST_OFFSET);
        /**
         * 设置消费模型，集群还是广播，默认为集群
         */
        consumer.setMessageModel(MessageModel.CLUSTERING);
        // 设置监听类，只能设置一个
        consumer.registerMessageListener(new ConsumerListener());
        // 设置订阅的topic 和 tag
        consumer.subscribe(topic, tag);
        consumer.start();

        System.out.println("================>消费者配置完成，ConsumerGroupName:" + groupName + ", Topics:" + topic + ", namesrvAddr:" + namesrvAddr);
        return consumer;
    }

}
