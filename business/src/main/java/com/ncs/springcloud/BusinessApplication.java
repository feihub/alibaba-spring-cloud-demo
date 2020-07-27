package com.ncs.springcloud;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
@RestController
@EnableFeignClients
@RefreshScope
@EnableRedisHttpSession
public class BusinessApplication {

    @Autowired
    private Business2Client business2Client;
    
    @Autowired
    private GitAutoRefreshConfig gitAutoRefreshConfig;
    
    public static void main(String[] args) {
        SpringApplication.run(BusinessApplication.class, args);
    }

    @RequestMapping("/")
    @HystrixCommand(fallbackMethod="businessFallback")
    public String home() {

        int i = 1/0;

        return "business";
    }

    public String businessFallback() {
        return "businessFallback";
    }
    
    @RequestMapping("/openfeign/test")
    public String test() {
        return business2Client.getTest();
    }

    @RequestMapping(value = "/autoShow")
    public Object autoShow(){
        return gitAutoRefreshConfig;
    }

    @GetMapping("/user")
    public String hello() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName() + Arrays.toString(authentication.getAuthorities().toArray());
    }
}
