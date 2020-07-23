package com.halley.bean;

/**
 * @author Jan
 * @Date 2020/7/23 12:34
 */
public class Field {

    private String deptName;
    private String date;

    @Override
    public String toString() {
        return "Field{" +
                "deptName='" + deptName + '\'' +
                ", date='" + date + '\'' +
                '}';
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
}
