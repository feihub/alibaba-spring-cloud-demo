package com.ncs.springcloud;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
@RestController
@EnableFeignClients
public class BusinessApplication {

    @Autowired
    private Business2Client business2Client;
    
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
    public String home() {
        return business2Client.getTest();
    }

}
