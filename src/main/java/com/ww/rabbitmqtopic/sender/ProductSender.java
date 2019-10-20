package com.ww.rabbitmqtopic.sender;

import com.ww.rabbitmqtopic.TopicConstants;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductSender {
    @Autowired
    RabbitTemplate rabbitTemplate;

    public void send(String msg){
        rabbitTemplate.convertAndSend(TopicConstants.EXCHANGE_NAME, TopicConstants.PRODUCT_INFO_ROUTING_KEY, "product...info..."+msg);
        rabbitTemplate.convertAndSend(TopicConstants.EXCHANGE_NAME, TopicConstants.PRODUCT_ERROR_ROUTING_KEY, "product...error..."+msg);
        rabbitTemplate.convertAndSend(TopicConstants.EXCHANGE_NAME, TopicConstants.PRODUCT_DEBUG_ROUTING_KEY, "product...debug..."+msg);
    }
}
