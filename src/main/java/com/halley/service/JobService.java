package com.halley.service;

import com.halley.bean.Job;
import com.halley.mapper.JobMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    JobMapper jobMapper;

    public List<Job> getAllJob(){

        return jobMapper.getAllJob();
    }
    public Job getByNo(Integer JobNo){

        return jobMapper.getByNo(JobNo);
    }
}
