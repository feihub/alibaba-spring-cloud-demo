package com.ncs.springcloud;

import com.google.common.util.concurrent.RateLimiter;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
@RestController
public class GatewayApplication {

    RateLimiter rateLimiter = RateLimiter.create(5);
    
    @Bean
    public HostAddrKeyResolver hostAddrKeyResolver() {
        return new HostAddrKeyResolver();
    }
    
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    @RequestMapping("/")
    @HystrixCommand(fallbackMethod="gatewayFallback")
    public String home() {

        int i = 1/0;

        return "gateway";
    }

    public String gatewayFallback() {
        return "gatewayFallback";
    }

    @RequestMapping("/test/rateLimiter")
    @HystrixCommand(fallbackMethod="gatewayFallback")
    public String testRateLimiter() {
        if(rateLimiter.tryAcquire()){
            return "testRateLimiterOk";
        }else{
            throw new RuntimeException("test");
        }
    }
}
