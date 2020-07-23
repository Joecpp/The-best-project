package com.halley.bean;

import java.sql.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Jan
 * @Date 2020/7/22 17:17
 */
public class ImportForJson {
    private Integer empNo;
    private String empName;
    private String deptName;
    private String date;
    private String year;
    private String month;
    private double num;

    @Override
    public String toString() {
        return "ImportForJson{" +
                "empNo=" + empNo +
                ", empName='" + empName + '\'' +
                ", deptName='" + deptName + '\'' +
                ", date='" + date + '\'' +
                ", year='" + year + '\'' +
                ", month='" + month + '\'' +
                ", num=" + num +
                ", map=" + map +
                '}';
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public double getNum() {
        return num;
    }

    public void setNum(double num) {
        this.num = num;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getYear() {
        return year;
    }

    public void setYear() {
        this.year = this.date.toString().split("-")[0];
    }

    public String getMonth() {
        return month;
    }

    public void setMonth() {
        this.month = this.year = this.date.toString().split("-")[1];
    }

    private Map<String,Double> map;

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

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public ImportForJson() {
    }

    public ImportForJson(Integer empNo, String empName, String deptName, String date, Map map) {
        this.empNo = empNo;
        this.empName = empName;
        this.deptName = deptName;
        this.date = date;
        this.map = map;
        this.year = this.date.toString().split("-")[0];
        this.month = this.year = this.date.toString().split("-")[1];

    }


}
