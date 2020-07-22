# Spring Cloud Demo
## spring-cloud:Greenwich.SR6
## spring-boot:2.1.9.RELEASE
## Spring Cloud Config/Spring Cloud Bus/Spring Cloud Gateway/Spring Cloud OpenFeign/Spring Cloud Netflix(Eureka/Ribbon/Hystrix) + Turbine/Spring Cloud Sleuth + Zipkin

## gateway:     8086
### http://localhost:8086
### http://localhost:8086/business/
### http://localhost:8086/business2/
### http://localhost:8086/business/openfeign/test
### http://localhost:8086/test/rateLimiter

## business:    8088
### http://localhost:8088
### http://localhost:8088/openfeign/test
### http://localhost:8088/autoShow
### GET:http://localhost:8082/actuator/refresh

## business2:   8014
### http://localhost:8014

## config:      8082
### http://localhost:8082
### POST:http://localhost:8082/actuator/bus-refresh

## eureka:      8084
### http://localhost:8084

## hystrix:     8010
### http://localhost:8010
### http://localhost:8010/hystrix
### http://localhost:8010/turbine.stream

## log:         8012
### http://localhost:8012
### http://localhost:8012/zipkin/
