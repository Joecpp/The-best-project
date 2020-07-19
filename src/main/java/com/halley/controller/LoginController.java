package com.halley.controller;

import com.halley.bean.Admin;
import com.halley.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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
    public Map Login(@RequestBody Admin user){
        Admin admin = adminService.adminLogin(user);
        Map map = new HashMap(3);

        if(admin!=null){
            map.put("admin",admin);
        }else {
            map.put("msg","账号或密码错误");
        }

        return map;
    }

}
