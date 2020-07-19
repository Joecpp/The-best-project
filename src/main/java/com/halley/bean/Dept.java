package com.halley.bean;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @author Jan
 * @Date 2020/7/18 21:20
 */
@Repository
public class Dept {
    private Integer deptNo;
    private String deptName;
    private String deptInfo;

    public Dept() {
    }

    public Dept(Integer deptNo, String deptName, String deptInfo) {
        this.deptNo = deptNo;
        this.deptName = deptName;
        this.deptInfo = deptInfo;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptNo=" + deptNo +
                ", deptName='" + deptName + '\'' +
                ", deptInfo='" + deptInfo + '\'' +
                '}';
    }

    public Integer getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(Integer deptNo) {
        this.deptNo = deptNo;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptInfo() {
        return deptInfo;
    }

    public void setDeptInfo(String deptInfo) {
        this.deptInfo = deptInfo;
    }
}

