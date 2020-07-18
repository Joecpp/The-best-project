package com.halley.controller;

import com.halley.bean.Admin;
import org.springframework.web.bind.annotation.*;

/**
 * @author Jan
 * @Date 2020/7/17 14:05
 */
@RestController
public class LoginController {


    @RequestMapping(value = "/login")
    @ResponseBody
    public Admin Login(@RequestBody Admin user){

        System.out.println(user);
        return user;
    }

}
