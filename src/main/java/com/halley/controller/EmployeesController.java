package com.halley.controller;

import com.halley.bean.Dept;
import com.halley.bean.Employees;
import com.halley.bean.Job;
import com.halley.service.EmployeesService;
import com.halley.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Joe
 * @date 2020/7/21 15:16
 */
@Controller
@RequestMapping("/emp")
public class EmployeesController {

    @Autowired
    EmployeesService service;

    @RequestMapping("/getAll")
    @ResponseBody
    public Map getAllEmp(){
        HashMap<String, Object> hashMap = new HashMap<>();
        List<Employees> list = service.getAllEmp();
        hashMap.put("allEmp", list);
        return hashMap;
    }

    @RequestMapping("/search")
    @ResponseBody
    public Map searchEmp(@RequestBody Map map) {
        HashMap<String, Object> hashMap = new HashMap<>();
        String s1;
        String s2;

        Integer deptNo = null;
        Integer empNo;
        String empName;
        s1 = (String) map.get("empNo");
        s2 = (String) map.get("empName");

        empNo = null;
        try {
            empNo = Integer.valueOf(s1.trim());
            deptNo = (Integer) map.get("deptNo");
        } catch (ClassCastException|NullPointerException | NumberFormatException exception) {
            hashMap.put("msg", "编号只能输入数字");
        }
        empName = s2.trim();
        List<Employees> list = service.searchEmp(empNo, empName,deptNo);
        hashMap.put("allEmp", list);
        return hashMap;
    }

    @RequestMapping("/add")
    @ResponseBody
    public Map addEmp(@RequestBody Employees emp) {
        HashMap<String, Object> hashMap = new HashMap<>();
        if (service.isRepeat(emp)) {
            hashMap.put("msg", "员工编号已存在");
            return hashMap;
        }
        if (service.addEmployee(emp)) {
            hashMap.put("msg", "添加成功");
        } else {
            hashMap.put("msg", "添加失败");
        }
        return hashMap;
    }

    @RequestMapping("/edit")
    @ResponseBody
    public Map editJob(@RequestBody Employees emp) {
        HashMap hashMap = new HashMap();
        if (service.updateEmp(emp)) {
            hashMap.put("msg", "1");
        } else {
            hashMap.put("msg", "0");
        }
        return hashMap;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Map deleteEmp(@RequestBody Employees emp) {
        Map hashMap = new HashMap();
        if (service.deleteEmp(emp.getEmpNo())) {
            hashMap.put("msg", "1");
        } else {
            hashMap.put("msg", "0");
        }
        return hashMap;
    }

    @RequestMapping("/deleteMul")
    @ResponseBody
    public Map deleteMulEmp(@RequestBody List<Employees> emps) {
        HashMap hashMap = new HashMap();
        Integer num = service.deleteMulEmp(emps);
        hashMap.put("msg", num);
        return hashMap;
    }
}
