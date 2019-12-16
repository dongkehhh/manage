package com.jec.manage.service.serviceImpl;

import com.jec.manage.bean.Admin;
import com.jec.manage.dao.AdminMapper;
import com.jec.manage.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminMapper adminMapper;
    @Override
    public Admin selectLogin(String username) {
        return adminMapper.selectLogin(username);
    }
}
