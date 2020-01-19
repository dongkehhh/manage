package com.jec.manage.controller;

import com.jec.manage.bean.Logs;
import com.jec.manage.service.LogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LogsController {
    @Autowired
    LogsService logsService;
    @RequestMapping("insertLogs")
    public Integer insetLogs(Logs logs){
        Integer integer = logsService.insertLogs(logs);
        return  integer;
    }
    @RequestMapping("selectLogs")
    public List<Logs> selectLogs(String name){
        return logsService.selectLogs(name);
    }
}
