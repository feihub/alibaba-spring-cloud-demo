package com.ncs.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class GateWayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GateWayApplication.class, args);
    }

    @RequestMapping("/")
    public String home(){
        return "GateWayApplicationOk";
    }
    
    @GetMapping("/mono")
    @SentinelResource("hello")
    public Mono<String> mono() {
	return Mono.just("simple string")
			.transform(new SentinelReactorTransformer<>("otherResourceName"));
    }
}
