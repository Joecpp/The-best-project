package com.halley.bean;

/**
 * @author Jan
 * @Date 2020/7/18 21:20
 */
public class Dept {
    private Integer deptNo;
    private String deptName;
    private String deptInfo;

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

