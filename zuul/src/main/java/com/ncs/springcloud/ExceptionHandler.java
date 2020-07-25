package com.ncs.springcloud;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionHandler implements ErrorController {

    @Override
    public String getErrorPath() {
        return "error";
    }

    @RequestMapping(value="/error")
    public String error(){
        return "{\"result\":\"please try later！！！\"}";
    }

}
