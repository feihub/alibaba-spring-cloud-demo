package com.ncs.springcloud;

import com.alibaba.csp.sentinel.adapter.reactor.SentinelReactorTransformer;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class GateWayApplication {

    @Bean
    public HostAddrKeyResolver hostAddrKeyResolver() {
        return new HostAddrKeyResolver();
    }
	
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
