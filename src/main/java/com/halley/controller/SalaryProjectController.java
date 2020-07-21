package com.halley.controller;

import com.halley.bean.ProjectIntegrate;
import com.halley.bean.Response;
import com.halley.service.SalaryProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResponseErrorHandler;

import java.util.List;

/**
 * @author Jan
 * @Date 2020/7/20 22:05
 */
@Controller
public class SalaryProjectController {
    @Autowired
    SalaryProjectService salaryProjectService;


    @PostMapping(value = "/SalaryProject")
    @ResponseBody
    public Response getSalaryProject(@RequestBody ProjectIntegrate projectIntegrate){
        Response response = new Response();
        List<ProjectIntegrate> salaryProjectByCondition = salaryProjectService.getSalaryProjectByCondition(projectIntegrate);
        System.out.println(salaryProjectByCondition);
        response.success(salaryProjectByCondition);
        return response;
    }


    @PutMapping(value = "/SalaryProject")
    @ResponseBody
    public Response insertSalaryProject(@RequestBody ProjectIntegrate projectIntegrate){
        Response response = new Response();
        System.out.println(projectIntegrate);
        salaryProjectService.insertItem(projectIntegrate);
        response.success();
        return response;
    }

    @GetMapping(value = "/SalaryProject")
    @ResponseBody
    public Response getSalaryName(){
        Response response = new Response();
        List<String> projectName = salaryProjectService.getProjectName();
        response.success(projectName);
        return response;
    }

    @PostMapping(value = "/SalaryProjects")
    @ResponseBody
    public Response updateSalaryProjects(@RequestBody ProjectIntegrate projectIntegrate){
        Response response = new Response();
        salaryProjectService.updateBase(projectIntegrate);
        return response;
    }

    @PostMapping(value = "/SalaryProjectss")
    @ResponseBody
    public Response deleteProject(@RequestBody ProjectIntegrate projectIntegrate){
        System.out.println("---------------------------------"+projectIntegrate);
        Response response = new Response();
        String s = salaryProjectService.deleteProject(projectIntegrate);
        response.failure(s);
        return response;
    }

}
