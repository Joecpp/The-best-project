package com.halley.service;

import com.halley.bean.Admin;
import com.halley.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Jan
 * @Date 2020/7/18 22:52
 */
@Service
public class AdminService {
    @Autowired
    AdminMapper adminMapper;
    public Admin adminService(){
        Admin admin = adminMapper.getAdminByUsername("admin");
        return admin;
    }
}
