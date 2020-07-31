package com.ncs.springcloud;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.google.common.util.concurrent.RateLimiter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
@EnableRedisHttpSession
public class Business2Application {

    RateLimiter rateLimiter = RateLimiter.create(5);

    public static void main(String[] args) {
        SpringApplication.run(Business2Application.class, args);
    }

    @RequestMapping("/")
    @SentinelResource(fallback="business2Fallback")
    public String home() {

        int i = 1/0;

        return "business2";
    }

    @RequestMapping("/openfeign/test")
    @SentinelResource(fallback="business2Fallback")
    public String openfeignTest() {
        return "business2OpenFeignTest";
    }

    public String business2Fallback() {
        return "business2Fallback";
    }

    @RequestMapping("/test/rateLimiter")
    @SentinelResource(fallback="business2Fallback")
    public String testRateLimiter() {
        if(rateLimiter.tryAcquire()){
            return "testRateLimiterOk";
        }else{
            throw new RuntimeException("test");
        }
    }
    
}
