package com.halley.controller;

import com.halley.bean.Dept;
import com.halley.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

/**
 * @author Joe
 * @date 2020/7/21 15:16
 */
@Controller
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    DeptService deptService;

    @RequestMapping("/search")
    @ResponseBody
    public Map searchDept(@RequestBody Map map) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        String s1, s2;
        s1 = (String) map.get("deptNo");
        s2 = (String) map.get("deptName");
        Integer deptNo = null;
        try {
            deptNo = Integer.valueOf(s1.trim());
        } catch (NullPointerException | NumberFormatException exception) {
            hashMap.put("msg", "编号只能输入数字");
        }
        String deptName = s2;
        List<Dept> list = deptService.searchDept(deptNo, deptName);
        hashMap.put("allDept", list);
        return hashMap;
    }

    @RequestMapping("/add")
    @ResponseBody
    public Map addDept(@RequestBody Dept dept) {
        HashMap<String, Object> hashMap = new HashMap<>();
        if (deptService.isRepeat(dept)) {
                hashMap.put("msg", "部门编号已存在");
                return hashMap;
            }
            if (deptService.addDept(dept)) {
                hashMap.put("msg", "添加成功");
            } else {
                hashMap.put("msg", "添加失败");
            }
            return hashMap;
        }

        @RequestMapping("/edit")
        @ResponseBody
        public Map editDept (@RequestBody Dept dept){
        HashMap hashMap = new HashMap();
        if (deptService.updateDept(dept)){
            hashMap.put("msg", "1");
        } else {
            hashMap.put("msg", "0");
        }
        return hashMap;
        }

    @RequestMapping("/delete")
    @ResponseBody
    public Map deleteDept (@RequestBody Dept dept){
        Map hashMap = new HashMap();
        if (deptService.deleteDept(dept.getDeptNo())) {
            hashMap.put("msg", "1");
        } else {
            hashMap.put("msg", "0");
        }
        return hashMap;
    }
    @RequestMapping("/deleteMul")
    @ResponseBody
    public Map deleteMulDept (@RequestBody List<Dept> list) {
        HashMap hashMap = new HashMap();
        Integer num = deptService.deleteMultiDept(list);
        hashMap.put("msg", num);
        return hashMap;
    }
//    @RequestMapping("/")
//    @ResponseBody
//    public String dept(){
//        ModelMap modelMap = new ModelMap();
//        modelMap.addAttribute("allDept",deptService.getAllDept());
//        return "/dept";
//    }
    }
