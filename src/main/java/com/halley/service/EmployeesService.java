package com.halley.service;

import com.halley.bean.Dept;
import com.halley.bean.Employees;
import com.halley.mapper.DeptMapper;
import com.halley.mapper.EmployeesMapper;
import com.halley.mapper.JobMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;


/**
 * @author Joe
 * @date 2020/7/21 15:16
 */
@Service
@RequestMapping("/emp")
public class EmployeesService {

    @Autowired
    EmployeesMapper mapper;

    @Autowired
    DeptMapper deptMapper;

    @Autowired
    JobMapper jobMapper;

    public List<Employees> getAllEmp(){
        List<Employees> list = mapper.getAllEmp();
        return list;
    }

    public boolean isRepeat(Employees emp){
        List<Employees> list = mapper.getAllEmp();
        boolean flag = false;
        if(list.isEmpty()){

        }else {
            for (Employees tmp:list) {
                if (emp.getEmpNo()==tmp.getEmpNo()){
                    flag = true;
                }
            }
        }
        return flag;
    }

    public  List<Employees> searchEmp(Integer empNo, String empName, Integer deptNo){
        List<Employees> list = mapper.getByThree(empNo,empName,deptNo);


        return list;
    }

    public boolean addEmployee(Employees emp){
        boolean flag = false;
        if (mapper.addEmp(emp)){
            flag = true;
        }
        return flag;
    }

    public Integer deleteMulEmp(List<Employees> emps){
        Integer num=0;
        for (Employees tmp:emps){
            if(mapper.deleteEmp(tmp.getEmpNo())) {
                num++;
            }
        }
        return num;
    }

    public boolean deleteEmp(Integer empNo){
        boolean flag=false;
        if (mapper.deleteEmp(empNo)){
            flag = true;
        }
        return flag;
    }

    public boolean updateEmp(Employees emp){
        boolean flag=false;
        if (mapper.updateEmp(emp)){
            flag = true;
        }
        return flag;
    }


}
