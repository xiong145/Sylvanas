package consumer.service;

import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author xiong
 */
@Component
public class ConsumerListener implements MessageListenerConcurrently {
    @Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> extList, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
        MessageExt ext = extList.get(0);
        try {
            //处理消息业务 收到的body（消息体），字节类型，需转为String
            String result = new String(ext.getBody());
            System.out.println("监听到了消息，Msgid" + ext.getMsgId() + ",topic为：" + ext.getTopic() + ",tags:" + ext.getTags() + ",keys" + ext.getKeys() + "消息内容为：" + result);
//            Thread.sleep(20);
        } catch (Exception e) {
            e.printStackTrace();
            //处理失败返回状态
            return ConsumeConcurrentlyStatus.RECONSUME_LATER;
        }
        //如果处理成功返回
        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
    }


}
