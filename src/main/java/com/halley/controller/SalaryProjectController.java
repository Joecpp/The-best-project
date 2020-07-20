package com.halley.controller;

import com.halley.bean.ProjectIntegrate;
import com.halley.bean.Response;
import com.halley.service.SalaryProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

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
        response.success(salaryProjectByCondition);
        return response;
    }
}
