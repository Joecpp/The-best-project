package com.halley.controller;

import com.halley.bean.ImportForJson;
import com.halley.bean.ImportRec;
import com.halley.bean.Response;
import com.halley.service.ImportManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Jan
 * @Date 2020/7/22 11:39
 */
@Controller
public class ImportManageController {
    @Autowired
    ImportManageService importManageService;

    @GetMapping("/importItem")
    @ResponseBody
    public Response getImportItem(){
        Response response = new Response();
        List<String> importName = importManageService.getImportName();
        response.success(importName);
        return response;
    }

    @PostMapping("/importProjects")
    @ResponseBody
    public Response getImportProjects(@RequestBody ImportForJson importForJson){
        Response response = new Response();
        List<ImportForJson> importForJson1 = importManageService.getImportForJson(importForJson);

        response.success(importForJson1);
        return response;
    }

    @PutMapping("/importProjects")
    @ResponseBody
    public Response updateProject(@RequestBody ImportForJson importForJson){
        Response response = new Response();
        importManageService.updateImportRec(importForJson);
        response.success();
        return response;
    }
}
