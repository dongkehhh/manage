package com.jec.manage.LogAspect;


import com.jec.manage.Util.IPUtils;
import com.jec.manage.bean.Admin;
import com.jec.manage.service.LogsService;
import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;


@Aspect
@Component
public class LogsAspect {

    @Autowired
    LogsService logsService;
    //@Pointcut("@annotation(com.jec.manage.LogAspect.LogsAnno)")
    //  @Pointcut("execution(* com.jec.manage.service.serviceImpl.StudentServiceImpl.insertSelective(..))")
   // public void in(){}

    //@Around("in()")
   /* public Object inser(ProceedingJoinPoint pjp)throws Throwable{
        // 1.方法执行前的处理，相当于前置通知
        // 获取方法签名
         MethodSignature methodSignature = (MethodSignature)pjp.getSignature();
        // 获取方法
        Method method1 = methodSignature.getMethod();
        //获取目标对象的类对象(字节码对象：反射的起点)
        Class<?> targetCls = pjp.getTarget().getClass();
        //获取目标方法对象
        Method targetMethod=targetCls.getDeclaredMethod(
                methodSignature.getName(),methodSignature.getParameterTypes());
        // 获取方法上面的注解
        LogsAnno logsAnno = method1.getAnnotation(LogsAnno.class);
        String method=targetCls.getName()+"."+targetMethod.getName();
        String params= Arrays.toString(pjp.getArgs());
        //获取当前登录用户
        Admin admin = (Admin) SecurityUtils.getSubject().getPrincipal();
        System.out.println("admin========="+admin);
        String username = admin.getUsername();
        String ip = IPUtils.getIpAddr();
        // 获取操作描述的属性值
        String title = logsAnno.title();
      *//*  Logs logs = new Logs();
        logs.setUsername(username);
        logs.setOperation(title);
        logs.setMethod(method);
        logs.setParams(params);
        logs.setIp(ip);
        logs.setCreatedtime(new Date());*//*

      *//*  Map map = logsService.insertLogs(logs);
        Object proceed = pjp.proceed();
        System.out.println(proceed);
        System.out.println(map);*//*
        //return proceed;
    }*/
}
