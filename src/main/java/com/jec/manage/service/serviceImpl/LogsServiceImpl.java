package com.jec.manage.service.serviceImpl;

import com.jec.manage.bean.Logs;
import com.jec.manage.dao.LogsMapper;
import com.jec.manage.service.LogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class LogsServiceImpl implements LogsService {
    @Autowired
    LogsMapper logsMapper;


    @Override
    public List<Logs> selectLogs(String username) {
        return logsMapper.selectLogs(username);
    }

    @Override
    public Map insertLogs(Logs logs) {
        int i = logsMapper.insertSelective(logs);
        HashMap<String, Boolean> map = new HashMap<>();
        if (i==0){
            map.put("success",false);
        }else {
            map.put("success",true);
        }
        return map;
    }
}
