package com.halley.bean;

/**
 * @author Jan
 * @Date 2020/7/18 21:16
 */
public class BaseRec {
    private Integer baseNo;
    private Integer deptNo;
    private double baseSalary;

    @Override
    public String toString() {
        return "BaseRec{" +
                "baseNo=" + baseNo +
                ", deptNo=" + deptNo +
                ", baseSalary=" + baseSalary +
                '}';
    }

    public Integer getBaseNo() {
        return baseNo;
    }

    public void setBaseNo(Integer baseNo) {
        this.baseNo = baseNo;
    }

    public Integer getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(Integer deptNo) {
        this.deptNo = deptNo;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }
}
