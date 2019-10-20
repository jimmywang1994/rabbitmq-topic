package com.ww.rabbitmqtopic.sender;

import com.ww.rabbitmqtopic.TopicConstants;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderSender {
    @Autowired
    RabbitTemplate rabbitTemplate;

    public void send(String msg){
//        rabbitTemplate.convertAndSend(TopicConstants.EXCHANGE_NAME, TopicConstants.ORDER_INFO_ROUTING_KEY, "order...info..."+msg);
        while (true){
            try {
                Thread.sleep(2000);
                rabbitTemplate.convertAndSend(TopicConstants.EXCHANGE_NAME, TopicConstants.ORDER_ERROR_ROUTING_KEY, "order...error..."+msg);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

//        rabbitTemplate.convertAndSend(TopicConstants.EXCHANGE_NAME, TopicConstants.ORDER_DEBUG_ROUTING_KEY, "order...debug..."+msg);
    }
}
