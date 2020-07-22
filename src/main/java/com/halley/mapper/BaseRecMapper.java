package com.halley.mapper;

import com.halley.bean.BaseIntegrate;
import com.halley.bean.BaseRec;

import java.util.List;

/**
 * @author Jan
 * @Date 2020/7/21 21:45
 */
public interface BaseRecMapper {

    /**
     * 获得所有BaseRec
     * @return
     */
    List<BaseRec> getAllBaseRec();

    /**
     * 获得Base
     * @param empName
     * @return
     */
    List<BaseRec> getBaseRecByEmpNo(Integer empName);

    /**
     * 获得Base
     * @param deptName
     * @return
     */
    List<BaseRec> getBaseRecByDeptName(String deptName);

    /**
     * 获得
     * @param high
     * @param low
     * @return
     */
    List<BaseRec> getBaseRecBySalary(double high, double low);


    /**
     * 更改
     * @param baseNo
     * @param deptNo
     * @param baseSalary
     */
    void updateBaseRec(Integer baseNo,Integer deptNo, double baseSalary);
}
