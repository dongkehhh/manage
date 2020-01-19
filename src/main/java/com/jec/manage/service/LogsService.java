package com.jec.manage.service;


import com.jec.manage.bean.Logs;

import java.util.List;

public interface LogsService {
    List<Logs> selectLogs(String name);

     Integer insertLogs(Logs logs);
}
