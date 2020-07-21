package com.halley.controller;

import com.halley.bean.Job;
import com.halley.service.JobService;
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
@RequestMapping("/job")
public class JobController {

    @Autowired
    JobService jobService;

    @RequestMapping("/search")
    @ResponseBody
    public Map searchJob(@RequestBody Map map) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        String s1, s2;
        s1 = (String) map.get("jobNo");
        s2 = (String) map.get("jobName");
        Integer jobNo = null;
        try {
            jobNo = Integer.valueOf(s1.trim());
        } catch (NullPointerException | NumberFormatException exception) {
            hashMap.put("msg", "编号只能输入数字");
        }
        String jobName = s2;
        List<Job> list = jobService.searchJob(jobNo, jobName);
        hashMap.put("allJob", list);
        return hashMap;
    }

    @RequestMapping("/add")
    @ResponseBody
    public Map addJob(@RequestBody Job job) {
        HashMap<String, Object> hashMap = new HashMap<>();
        if (jobService.isRepeat(job)) {
            hashMap.put("msg", "岗位编号已存在");
            return hashMap;
        }
        if (jobService.addJob(job)) {
            hashMap.put("msg", "添加成功");
        } else {
            hashMap.put("msg", "添加失败");
        }
        return hashMap;
    }

    @RequestMapping("/edit")
    @ResponseBody
    public Map editJob(@RequestBody Job job) {
        HashMap hashMap = new HashMap();
        if (jobService.updateJob(job)) {
            hashMap.put("msg", "1");
        } else {
            hashMap.put("msg", "0");
        }
        return hashMap;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Map deleteJob(@RequestBody Job job) {
        Map hashMap = new HashMap();
        if (jobService.deleteJob(job.getJobNo())) {
            hashMap.put("msg", "1");
        } else {
            hashMap.put("msg", "0");
        }
        return hashMap;
    }

    @RequestMapping("/deleteMul")
    @ResponseBody
    public Map deleteMulJob(@RequestBody List<Job> list) {
        HashMap hashMap = new HashMap();
        Integer num = jobService.deleteMultiJob(list);
        hashMap.put("msg", num);
        return hashMap;
    }
//    @RequestMapping("/")
//    @ResponseBody
//    public String job(){
//        ModelMap modelMap = new ModelMap();
//        modelMap.addAttribute("allJob",jobService.getAllJob());
//        return "/job";
//    }
}


