package com.jec.manage.shiro;


import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class NoDefaultExceptionHandler {

    @ExceptionHandler(UnauthorizedException.class)
    @ResponseBody
    public String NoDefaultExceptionHandler(){
        return "403.html";
    }
}
