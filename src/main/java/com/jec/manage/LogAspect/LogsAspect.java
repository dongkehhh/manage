package com.jec.manage.LogAspect;


import com.jec.manage.dao.LogsMapper;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LogsAspect {

    @Autowired
    LogsMapper logsMapper;
    @Pointcut("execution(* com.jec.manage.controller.StudentController.insertSelective())")
    public void in(){}

    @Around("in()")
    public void inser(){

    }
}
