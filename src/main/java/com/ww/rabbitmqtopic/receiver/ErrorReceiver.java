package com.ww.rabbitmqtopic.receiver;

import com.ww.rabbitmqtopic.TopicConstants;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(bindings = @QueueBinding(
        value = @Queue(value = "log.error",autoDelete = "true"),
        exchange = @Exchange(value = TopicConstants.EXCHANGE_NAME,type = ExchangeTypes.TOPIC),
        key = "*.log.error"
))
public class ErrorReceiver {
    @RabbitHandler
    public void receive(String msg){
        System.out.println("......Error........receiver:"+msg);
    }
}
