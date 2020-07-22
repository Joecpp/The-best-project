package com.halley.controller;

import com.halley.bean.BaseForJson;
import com.halley.bean.BaseIntegrate;
import com.halley.bean.BaseRec;
import com.halley.bean.Response;
import com.halley.service.BaseManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Jan
 * @Date 2020/7/21 20:39
 */
@Controller
public class BaseManageController {
    @Autowired
    BaseManageService baseManageService;

    @GetMapping("/department")
    @ResponseBody
    public Response getAllDept(){
        Response response = new Response();
        List<String> allDeptName = baseManageService.getAllDeptName();
        response.success(allDeptName);
        return response;

    }

    @GetMapping("/baseItem")
    @ResponseBody
    public Response getAllBaseName(){
        Response response = new Response();
        List<String> allBaseName = baseManageService.getAllBaseName();
        response.success(allBaseName);
        return response;
    }

    @PostMapping("/baseRec")
    @ResponseBody
    public Response getBaseRecByCondition(@RequestBody BaseIntegrate baseIntegrate){
        Response response = new Response();
        List<BaseForJson> baseRecByCondition = baseManageService.getBaseRecByCondition(baseIntegrate);
        response.success(baseRecByCondition);
        return response;
    }
}
