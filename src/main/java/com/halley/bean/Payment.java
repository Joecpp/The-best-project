package com.halley.bean;

import java.sql.Date;

/**
 * @author Jan
 * @Date 2020/7/18 21:53
 */
public class Payment {
    private Integer empNo;
    private Date date;
    private int flag;
    private double salary;

    @Override
    public String toString() {
        return "Payment{" +
                "empNo=" + empNo +
                ", date=" + date +
                ", flag=" + flag +
                ", salary=" + salary +

                '}';
    }



    public Integer getEmpNo() {
        return empNo;
    }

    public void setEmpNo(Integer empNo) {
        this.empNo = empNo;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
