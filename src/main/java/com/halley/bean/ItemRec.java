package com.halley.bean;

import java.sql.Date;

/**
 * @author Jan
 * @int 2020/7/18 21:49
 */
public class ItemRec {
    private Integer itemNo;

    public Date getDate() {
        return date;
    }

    private Integer empNo;
    private Date date;
    private int flag;
    private double salary;

    @Override
    public String toString() {
        return "ItemRec{" +
                "itemNo=" + itemNo +
                ", empNo=" + empNo +
                ", mouth=" + date +
                ", flag=" + flag +
                ", salary=" + salary +
                '}';
    }

    public Integer getItemNo() {
        return itemNo;
    }

    public void setItemNo(Integer itemNo) {
        this.itemNo = itemNo;
    }

    public Integer getEmpNo() {
        return empNo;
    }

    public void setEmpNo(Integer empNo) {
        this.empNo = empNo;
    }

    public Date getMouth() {
        return date;
    }

    public void setMouth(Date mouth) {
        this.date = mouth;
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
