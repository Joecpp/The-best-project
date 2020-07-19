package com.halley.controller;

import com.halley.bean.Admin;
import com.halley.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

/**
 * @author Jan
 * @Date 2020/7/17 14:05
 */
@Controller
public class LoginController {
    @Autowired
    AdminService adminService;

    @RequestMapping(value = "/login")
    @ResponseBody
    public Admin Login(@RequestBody Admin user){

        System.out.println(user);
        return user;
    }

    @RequestMapping("/lll")
    @ResponseBody
    public Admin Lll(){
        Admin admin = adminService.adminService();
        return admin;
    }
}
