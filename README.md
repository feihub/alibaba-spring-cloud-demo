# Spring Cloud Demo2
- ### spring-cloud:Hoxton.SR6
- ### spring-boot:2.2.3.RELEASE
- #### Spring Cloud Alibaba(Nacos+Sentinel)/Spring Cloud Gateway/Spring Cloud Bus/Spring Cloud OpenFeign/Spring Cloud Security+ Oauth2 + SSO + Spring Session/Spring Cloud Netflix(Ribbon)/Spring Cloud Sleuth + Zipkin/Redis/RocketMQ

https://github.com/gf-huanchupk/SpringBootLearning/tree/master/springboot-security-oauth2-jwt

Spring Cloud Gateway 与 OAuth2 不兼容issue
https://github.com/artemMartynenko/spring-cloud-gateway-oauth2-sso-sample-application
https://www.learnnowlab.com/Spring-Cloud-Gateway-with-Spring-Security/

https://spring.io/blog/2019/08/16/securing-services-with-spring-cloud-gateway

https://github.com/steventong/simple-microservices

https://www.cnblogs.com/Irving/p/9430460.html

https://juejin.im/post/5f0affb6f265da231258a31d

## 1. eureka:      8084
- #### http://localhost:8084


## 2. config:      8082
- #### http://localhost:8082/business-dev.yml
- #### POST:http://localhost:8082/actuator/bus-refresh

## 3. oauth2:      8016   
- #### http://localhost:8016

## 4. zuul:     8086
- #### http://localhost:8086
- #### http://localhost:8086/business/
- #### http://localhost:8086/business/autoShow
- #### http://localhost:8086/business/openfeign/test
- #### http://localhost:8086/business2/
- #### http://localhost:8086/business2/test/rateLimiter
- #### POST:http://localhost:8086/actuator/refresh

## 5. business:    8088
- #### http://localhost:8088
- #### http://localhost:8088/openfeign/test
- #### http://localhost:8088/autoShow
- #### POST:http://localhost:8088/actuator/refresh

## 6. business2:   8014
- #### http://localhost:8014
- #### http://localhost:8014/openfeign/test
- #### http://localhost:8014/test/rateLimiter
- #### POST:http://localhost:8014/actuator/refresh

## 7. turbine:     8010
- #### http://localhost:8010/hystrix
- #### http://localhost:8010/turbine.stream

## 8. zipkin:         8012
- #### http://localhost:8012

## 9. redis:         6379

## 10. rabbitmq:         5672
