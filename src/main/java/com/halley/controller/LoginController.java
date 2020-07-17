package com.halley.controller;

import com.halley.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Jan
 * @Date 2020/7/17 14:05
 */
@Controller
public class LoginController {

    @ResponseBody
    @RequestMapping(value = "/Login")
    public Model Login(Model model, @RequestBody User user){

        System.out.println(user);
        model.addAttribute("user",user);
        return model;
    }

}
