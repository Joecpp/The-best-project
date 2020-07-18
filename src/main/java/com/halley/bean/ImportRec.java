package com.halley.bean;

import java.sql.Date;

/**
 * @author Jan
 * @Date 2020/7/18 21:28
 */
public class ImportRec {
    private Integer importId;
    private Integer empNo;
    private Date month;
    private double num;

    public Integer getImportId() {
        return importId;
    }

    public void setImportId(Integer importId) {
        this.importId = importId;
    }

    public Integer getEmpNo() {
        return empNo;
    }

    public void setEmpNo(Integer empNo) {
        this.empNo = empNo;
    }

    public Date getMouth() {
        return month;
    }

    public void setMouth(Date month) {
        this.month = month;
    }

    public double getNum() {
        return num;
    }

    public void setNum(double num) {
        this.num = num;
    }
}
