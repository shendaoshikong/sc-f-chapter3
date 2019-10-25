package com.czp.springcloud.configserver;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
@RestController
public class ConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
        System.out.println("请访问下面的网址：");
        System.out.println("http://localhost:8888/config-client/dev/master");
    }

    //在引入Spring-AMQP后可以直接使用AmqpTemplate
    @Autowired
    private AmqpTemplate rabbitmqTemplate;

    /**
     * 生产者Send会向Queue=hello发送一条消息；
     */
    @GetMapping("/send")
    public void send(){
        String content = "hello" + new Date();
        System.out.println("Sender2:" +content);
        this.rabbitmqTemplate.convertAndSend("hello", content);
    }
}
