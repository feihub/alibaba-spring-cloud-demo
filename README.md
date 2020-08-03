# Spring Cloud Demo2
- ### spring-cloud:Hoxton.SR6
- ### spring-boot:2.2.3.RELEASE
- #### Spring Cloud Alibaba(Nacos+Sentinel)/Spring Cloud Gateway/Spring Cloud OpenFeign/Spring Cloud Security+ Oauth2 + SSO + Spring Session/Spring Cloud Netflix(Ribbon)

## 1. gateway:     8086

- #### problem: can not use @EnableOauth2Sso

- #### http://localhost:8086
- #### http://localhost:8086/business/
- #### http://localhost:8086/business/openfeign/test
- #### http://localhost:8086/business2/
- #### http://localhost:8086/business2/test/rateLimiter

## 2. oauth2:      8016   
- #### http://localhost:8016

## 3. business:    8088
- #### http://localhost:8088
- #### http://localhost:8088/openfeign/test

## 4. business2:   8014
- #### http://localhost:8014
- #### http://localhost:8014/openfeign/test
- #### http://localhost:8014/test/rateLimiter
