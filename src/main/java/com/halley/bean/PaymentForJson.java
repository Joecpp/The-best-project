package com.halley.bean;

import java.util.Map;

/**
 * @author Jan
 * @Date 2020/7/23 8:46
 */
public class PaymentForJson {
    private Integer empNo;
    private String empName;
    private double baseSalary;
    private double reallySalary;
    private Map map;

    @Override
    public String toString() {
        return "PaymentForJson{" +
                "empNo=" + empNo +
                ", empName='" + empName + '\'' +
                ", baseSalary=" + baseSalary +
                ", reallySalary=" + reallySalary +
                ", map=" + map +
                '}';
    }

    public Integer getempNo() {
        return empNo;
    }

    public void setempNo(Integer empNo) {
        this.empNo = empNo;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public double getReallySalary() {
        return reallySalary;
    }

    public void setReallySalary(double reallySalary) {
        this.reallySalary = reallySalary;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }
}
