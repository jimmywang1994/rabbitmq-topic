package com.ww.rabbitmqtopic.sender;

import com.ww.rabbitmqtopic.TopicConstants;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserSender {
    @Autowired
    RabbitTemplate rabbitTemplate;

    public void send(String msg){
        rabbitTemplate.convertAndSend(TopicConstants.EXCHANGE_NAME, TopicConstants.USER_INFO_ROUTING_KEY, "user...info..."+msg);
        rabbitTemplate.convertAndSend(TopicConstants.EXCHANGE_NAME, TopicConstants.USER_ERROR_ROUTING_KEY, "user...error..."+msg);
        rabbitTemplate.convertAndSend(TopicConstants.EXCHANGE_NAME, TopicConstants.USER_DEBUG_ROUTING_KEY, "user...debug..."+msg);
    }
}
