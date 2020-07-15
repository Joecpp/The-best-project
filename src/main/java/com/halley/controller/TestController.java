package com.halley.controller;

import com.halley.bean.Dog;
import com.halley.bean.TestBean;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/The_best_project_war_exploded")
public class TestController {

    @RequestMapping("/hello")
    public String hello(ModelMap modelMap){
        modelMap.addAttribute("name","Hello World");
        return "list";
    }

    @RequestMapping("/json")
    @ResponseBody
    public TestBean josn(){

        return new TestBean("乔云乐",200,new Dog("wang",2));
    }
}
