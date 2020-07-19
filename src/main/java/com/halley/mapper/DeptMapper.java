package com.halley.mapper;

import com.halley.bean.Dept;
import com.halley.bean.Job;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DeptMapper {

    public List<Dept> getAllDept();


    public Dept getByNo(Integer deptNo);
}
