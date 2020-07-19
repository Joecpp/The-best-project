package com.halley.mapper;

import com.halley.bean.Job;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component

public interface JobMapper {


    public List<Job> getAllJob();


    public Job getByNo(Integer JobNo);
}
