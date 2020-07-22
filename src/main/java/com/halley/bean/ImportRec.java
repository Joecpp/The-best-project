package com.halley.bean;


import java.sql.Date;

/**
 * @author Jan
 * @int 2020/7/18 21:28
 */
public class ImportRec {
    private Integer importNo;
    private Integer empNo;
    private Date date;
    private double num;

    public Integer getImportNo() {
        return importNo;
    }

    public void setImportNo(Integer importId) {
        this.importNo = importId;
    }

    public ImportRec() {
    }

    public ImportRec(Integer importNo, Integer empNo, Date date, double num) {
        this.importNo = importNo;
        this.empNo = empNo;
        this.date = date;
        this.num = num;
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

    public void setMouth(Date month) {
        this.date = month;
    }

    public double getNum() {
        return num;
    }

    public void setNum(double num) {
        this.num = num;
    }
}
