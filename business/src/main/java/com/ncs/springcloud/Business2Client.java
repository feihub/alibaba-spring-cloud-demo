package com.ncs.springcloud;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="business2", fallback = Business2Client.Business2ClientFallback.class,configuration = CustomerRequestInterceptor.class)
public interface Business2Client {

    @RequestMapping(method = RequestMethod.GET, value = "/openfeign/test")
    public String getTest();

    static class Business2ClientFallback implements Business2Client {
        @Override
        public String getTest() {
            return "business-feign-fallback";
        }
    }

}


