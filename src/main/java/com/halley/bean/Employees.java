package com.halley.bean;

/**
 * @author Jan
 * @Date 2020/7/18 21:25
 */
public class Employees {
    private Integer empNo;
    private String empName;
    private Integer deptNo;
    private Integer jobNo;

    @Override
    public String toString() {
        return "Employees{" +
                "empNo=" + empNo +
                ", empName='" + empName + '\'' +
                ", deptNo=" + deptNo +
                ", jobNo=" + jobNo +
                '}';
    }

    public Integer getEmpNo() {
        return empNo;
    }

    public void setEmpNo(Integer empNo) {
        this.empNo = empNo;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Integer getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(Integer deptNo) {
        this.deptNo = deptNo;
    }

    public Integer getJobNo() {
        return jobNo;
    }

    public void setJobNo(Integer jobNo) {
        this.jobNo = jobNo;
    }
}
