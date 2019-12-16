package com.jec.manage.service;

import com.jec.manage.bean.Admin;

public interface AdminService {
    Admin selectLogin(String username);
}
