package com.jec.manage.controller;

import com.jec.manage.bean.Logs;
import com.jec.manage.service.LogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class LogsController {
    @Autowired
    LogsService logsService;
    @RequestMapping("insertLogs")
    public Map insetLogs(Logs logs){
        Map map = logsService.insertLogs(logs);
        return  map;
    }
    @RequestMapping("selectLogs")
    public List<Logs> selectLogs(String username) {
        return logsService.selectLogs(username);
    }
}
