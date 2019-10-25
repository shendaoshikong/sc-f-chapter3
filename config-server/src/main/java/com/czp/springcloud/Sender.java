package com.czp.springcloud;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
//@Component
public class Sender {

    //在引入Spring-AMQP后可以直接使用AmqpTemplate
    @Autowired
    private AmqpTemplate rabbitmqTemplate;

    /**
     * 生产者Send会向Queue=hello发送一条消息；
     */
    @GetMapping("/send")
    public String send(){
        String content = "hello" + new Date();
        System.out.println("Sender:" +content);
        this.rabbitmqTemplate.convertAndSend("hello", content);
        return content;
    }

    @GetMapping("/send2")
    public String hh(){
        return "dasdasdasd";
    }
}