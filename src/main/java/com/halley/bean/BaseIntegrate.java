package com.halley.bean;

/**
 * @author Jan
 * @Date 2020/7/21 20:54
 */
public class BaseIntegrate {
    private double highSalary;

    public double getHighSalary() {
        return highSalary;
    }

    public void setHighSalary(double highSalary) {
        this.highSalary = highSalary;
    }

    public double getLowSalary() {
        return lowSalary;
    }

    public void setLowSalary(double lowSalary) {
        this.lowSalary = lowSalary;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Integer getEmpNo() {
        return empNo;
    }

    public void setEmpNo(Integer empNo) {
        this.empNo = empNo;
    }

    @Override
    public String toString() {
        return "BaseIntegrate{" +
                "highSalary=" + highSalary +
                ", lowSalary=" + lowSalary +
                ", deptName='" + deptName + '\'' +
                ", empNo=" + empNo +
                '}';
    }


    private double lowSalary;
    private String deptName;
    private Integer empNo;

}
