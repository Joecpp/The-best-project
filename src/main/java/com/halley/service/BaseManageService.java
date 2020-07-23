package com.halley.service;

import com.halley.bean.*;
import com.halley.mapper.BaseMapper;
import com.halley.mapper.BaseRecMapper;
import com.halley.mapper.DeptMapper;
import com.halley.mapper.EmployeesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Jan
 * @Date 2020/7/21 20:36
 */
@Service
public class BaseManageService {
    @Autowired
    DeptMapper deptMapper;

    @Autowired
    BaseMapper baseMapper;

    @Autowired
    BaseRecMapper baseRecMapper;

    @Autowired
    EmployeesMapper employeesMapper;


    public List<String> getAllDeptName() {
        List<Dept> allDept = deptMapper.getAllDept();
        List<String> list = new ArrayList<>();
        for (Dept dept : allDept) {
            list.add(dept.getDeptName());
        }
        return list;
    }

    public List<String> getAllBaseName() {
        List<Base> baseByFlag = baseMapper.getBaseByFlag(0);
        ArrayList<String> list = new ArrayList<>();
        for (Base base : baseByFlag
        ) {
            list.add(base.getBaseName());
        }
        return list;
    }

    public List<BaseForJson> getBaseRecByCondition(BaseIntegrate baseIntegrate) {
        String deptName = baseIntegrate.getDeptName();
        Integer empNo = baseIntegrate.getEmpNo();
        List<BaseForJson> list = new ArrayList<>();
        if ("".equals(deptName) ) {
            List<BaseRec> baseRecs = baseRecMapper.getAllBaseRec();
            for (BaseRec b :
                    baseRecs) {
                List<Employees> byDeptNo = employeesMapper.getByDeptNo(b.getDeptNo());
                Dept byNo = deptMapper.getByNo(b.getDeptNo());
                for (Employees s : byDeptNo) {
                    String name = baseMapper.getBaseNameByBaseNo(b.getBaseNo());
                    BaseForJson baseForJson = new BaseForJson(s.getEmpName(), s.getEmpNo(), name,b.getBaseSalary(),byNo.getDeptName());
                    list.add(baseForJson);
                }
            }
            return BaseForJson.Normalization(list);
        }
        else  {
            List<BaseRec> baseRecByDeptName = baseRecMapper.getBaseRecByDeptName(deptName);
            for (BaseRec b :
                    baseRecByDeptName) {
                List<Employees> byDeptNo = employeesMapper.getByDeptNo(b.getDeptNo());
                Dept byNo = deptMapper.getByNo(b.getDeptNo());
                for (Employees s : byDeptNo) {
                    String name = baseMapper.getBaseNameByBaseNo(b.getBaseNo());
                    BaseForJson baseForJson = new BaseForJson(s.getEmpName(), s.getEmpNo(), name,b.getBaseSalary(),byNo.getDeptName());
                    list.add(baseForJson);
                }
            }
        }


        return BaseForJson.Normalization(list);
    }
    @Transactional(rollbackFor=Exception.class)
    public void updateBaseRec(BaseForJson baseForJson){
        Integer deptNoByDeptName = deptMapper.getDeptNoByDeptName(baseForJson.getDeptName());
        Map map = baseForJson.getMap();
        Set<String> set = map.keySet();
        for(String s:set){
            Integer baseNoByBaseName = baseMapper.getBaseNoByBaseName(s);
            double baseSalary = Double.parseDouble(String.valueOf( map.get(s)));
            baseRecMapper.updateBaseRec(baseNoByBaseName,deptNoByDeptName,baseSalary);
        }

    }

}