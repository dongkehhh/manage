package com.jec.manage.service;

import com.jec.manage.bean.Logs;

import java.util.List;
import java.util.Map;


public interface LogsService {
    List<Logs> selectLogs(String username);

    public Map insertLogs(Logs logs);
}
