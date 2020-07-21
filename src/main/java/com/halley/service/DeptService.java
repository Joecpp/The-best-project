package com.halley.service;

import com.halley.bean.Dept;
import com.halley.mapper.DeptMapper;
import com.sun.codemodel.internal.JForEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Joe
 * @date 2020/7/21 15:16
 */
@Service
public class DeptService {
    @Autowired
    DeptMapper deptMapper;

    public List<Dept> searchDept(Integer deptNo,String deptName){
        List<Dept> list = deptMapper.getByNameAndNo(deptNo,deptName);
        return list;
    }

    public List<Dept> getAllDept(){
        List<Dept> list = deptMapper.getAllDept();
        return list;
    }

    public boolean addDept(Dept dept){
        boolean flag = deptMapper.addDept(dept);
        return flag;
    }

    public boolean updateDept(Dept dept){
        boolean flag = deptMapper.updateDept(dept);
        return flag;
    }

    public boolean deleteDept(Integer deptNo){
        boolean flag = deptMapper.deleteDept(deptNo);
        return flag;
    }

    /**
     * 批量删除部门
     * @param list
     * @return 删除成功的个数
     */
    public Integer deleteMultiDept(List<Dept> list){
        Integer num = 0;
        if (list != null) {
            for (Dept dept:
                 list) {
                if (deptMapper.deleteDept(dept.getDeptNo()) == true) {
                    num++;
                }
            }
        }
        return num;
    }

    public boolean isRepeat(Dept dept){
        List<Dept> list = deptMapper.getAllDept();
        boolean flag = false;
        if(list.isEmpty()){

        }else {
            for (Dept tmp:list) {
                if (dept.getDeptNo()==tmp.getDeptNo()){
                    flag = true;
                }
            }
        }
        return flag;
    }
}
