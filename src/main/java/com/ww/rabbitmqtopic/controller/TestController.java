package com.ww.rabbitmqtopic.controller;

import com.ww.rabbitmqtopic.sender.OrderSender;
import com.ww.rabbitmqtopic.sender.ProductSender;
import com.ww.rabbitmqtopic.sender.UserSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    OrderSender orderSender;
    @Autowired
    ProductSender productSender;
    @Autowired
    UserSender userSender;

    @RequestMapping("/hello")
    public void test() {
        orderSender.send("orderSender sending...");
//                productSender.send("productSender sending...");
//                userSender.send("userSender sending...");
    }
}
