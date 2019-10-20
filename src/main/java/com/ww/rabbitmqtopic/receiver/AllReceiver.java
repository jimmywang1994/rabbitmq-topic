package com.ww.rabbitmqtopic.receiver;

import com.ww.rabbitmqtopic.TopicConstants;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(bindings = @QueueBinding(
        value = @Queue(value = "log.info",autoDelete = "false"),
        exchange = @Exchange(value = TopicConstants.EXCHANGE_NAME,type = ExchangeTypes.TOPIC),
        key = "*.log.*"
))
public class AllReceiver {
    @RabbitHandler
    public void receiver(String msg){
        System.out.println("......All........receiver: "+msg);
    }
}
