package com.halley.service;

import com.halley.bean.*;
import com.halley.mapper.BaseMapper;
import com.halley.mapper.BaseRecMapper;
import com.halley.mapper.DeptMapper;
import com.halley.mapper.EmployeesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        double highSalary = baseIntegrate.getHighSalary();
        double lowSalary = baseIntegrate.getLowSalary();
        List<BaseForJson> list = new ArrayList<>();
        if (deptName == null && empNo == null && highSalary == 0 && lowSalary == 0) {
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
        if (deptName != null) {
            List<BaseRec> baseRecByDeptName = baseRecMapper.getBaseRecByDeptName(deptName);
            for (BaseRec b :
                    baseRecByDeptName) {
                List<Employees> byDeptNo = employeesMapper.getByDeptNo(b.getDeptNo());
                Dept byNo = deptMapper.getByNo(b.getDeptNo());
                for (Employees s : byDeptNo) {
                    String name = baseMapper.getBaseNameByItemNo(b.getBaseNo());
                    BaseForJson baseForJson = new BaseForJson(s.getEmpName(), s.getEmpNo(), name,b.getBaseSalary(),byNo.getDeptName());
                    list.add(baseForJson);
                }
            }
        }
        if (empNo != null) {
            List<BaseRec> baseRecByEmpNo = baseRecMapper.getBaseRecByEmpNo(empNo);
            for (BaseRec b :
                    baseRecByEmpNo) {
                List<Employees> byDeptNo = employeesMapper.getByDeptNo(b.getDeptNo());
                Dept byNo = deptMapper.getByNo(b.getDeptNo());
                for (Employees s : byDeptNo) {
                    String name = baseMapper.getBaseNameByItemNo(b.getBaseNo());
                    BaseForJson baseForJson = new BaseForJson(s.getEmpName(), s.getEmpNo(), name,b.getBaseSalary(),byNo.getDeptName());
                    list.add(baseForJson);
                }
            }
        }
        if (highSalary != 0 && lowSalary != 0) {
            List<BaseRec> baseRecBySalary = baseRecMapper.getBaseRecBySalary(highSalary, lowSalary);
            for (BaseRec b :
                    baseRecBySalary) {
                List<Employees> byDeptNo = employeesMapper.getByDeptNo(b.getDeptNo());
                Dept byNo = deptMapper.getByNo(b.getDeptNo());
                for (Employees s : byDeptNo) {
                    String name = baseMapper.getBaseNameByItemNo(b.getBaseNo());
                    BaseForJson baseForJson = new BaseForJson(s.getEmpName(), s.getEmpNo(), name,b.getBaseSalary(),byNo.getDeptName());
                    list.add(baseForJson);
                }
            }

        }
        return BaseForJson.Normalization(list);
    }

}