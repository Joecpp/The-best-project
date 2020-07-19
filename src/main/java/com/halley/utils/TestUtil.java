package com.halley.utils;

import com.halley.bean.Admin;
import com.halley.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Jan
 * @Date 2020/7/14 11:52
 */
public class TestUtil {
    @Autowired
    AdminService adminService;

    public void vvv(){
        System.out.println(adminService);
        adminService.adminService();
    }

}
