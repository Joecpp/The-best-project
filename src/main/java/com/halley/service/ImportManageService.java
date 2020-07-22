package com.halley.service;

import com.halley.bean.Employees;
import com.halley.bean.ImportForJson;
import com.halley.bean.ImportRec;
import com.halley.mapper.BaseMapper;
import com.halley.mapper.DeptMapper;
import com.halley.mapper.EmployeesMapper;
import com.halley.mapper.ImportMapper;
import com.halley.utils.IntegrateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jan
 * @Date 2020/7/22 11:29
 */
@Service
public class ImportManageService {
    @Autowired
    BaseMapper baseMapper;

    @Autowired
    ImportMapper importMapper;

    @Autowired
    EmployeesMapper employeesMapper;

    @Autowired
    DeptMapper deptMapper;

    public List<String> getImportName(){
        List<String> baseNameByFlag = baseMapper.getBaseNameByFlag(1);
        return baseNameByFlag;
    }

    public List<ImportForJson> getImportForJson(ImportForJson importForJson){
        List<ImportForJson> list = new ArrayList<>();
        String deptName = importForJson.getDeptName();
        Integer empNo = importForJson.getEmpNo();
        String date = importForJson.getDate();
        if(deptName!=null){
            List<Employees> byDeptNo = employeesMapper.getByDeptNo(deptMapper.getDeptNoByDeptName(deptName));
            for(Employees employee:byDeptNo){
                ImportForJson importForJson1 = new ImportForJson();
                importForJson1.setEmpNo(employee.getEmpNo());
                List<ImportForJson> list1 = IntegrateUtil.importIntegration(importMapper.getAllImportRec(importForJson1));
                list.addAll(list1);

            }
            return list;
        }
        List<ImportRec> allImportRec = importMapper.getAllImportRec(importForJson);
        list = IntegrateUtil.importIntegration(allImportRec);
        return list;
    }
}
