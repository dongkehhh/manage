package com.jec.manage.service.serviceImpl;

import com.jec.manage.bean.Logs;
import com.jec.manage.dao.LogsMapper;
import com.jec.manage.service.LogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogsServiceImpl implements LogsService {
    @Autowired
    LogsMapper logsMapper;


    @Override
    public List<Logs> selectLogs(String name) {
        return logsMapper.selectLogs(name);
    }

    @Override
    public Integer insertLogs(Logs logs) {
        return  logsMapper.insertSelective(logs);
    }
}
