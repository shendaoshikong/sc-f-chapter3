package com.czp.springcloud.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @EnableDiscoveryClient 和 @EnableEurekaClient 共同点就是：都是能够让注册中心能够发现，扫描到改服务。
 * 不同点：@EnableEurekaClient只适用于Eureka作为注册中心，@EnableDiscoveryClient 可以是其他注册中心。
 */
@SpringBootApplication
@EnableEurekaClient
@RestController
@RefreshScope
public class ConfigClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class, args);
        System.out.println("请访问下面的网址：");
        System.out.println("http://localhost:8882/hi");
    }

    @Value("${foo}")
    String foo;

    @GetMapping("/hi")
    public String hi(){
        return foo;
    }

    @GetMapping("/hi2")
    public String hi2(){
        return "dasdad";
    }
//
//    @GetMapping("/hi2")
//    public String hi2(@RequestParam(value = "foo") String ff){
//        return foo+ff;
//    }
//
//    @PostMapping("/hi3")
//    @ResponseBody
//    public String getProductPriceInfo() {
//        return foo;
//    }

//    @PostMapping("/hi1")
//    @ResponseBody
//    public String hi1() {
//        return  foo;
//
//    }
//
//    @PostMapping("/hi2")
//    public String hi2() {
//        return  foo;
//
//    }

}
