package com.halley.bean;

/**
 * @author Jan
 * @Date 2020/7/18 21:07
 */
public class Base {
    /**
     * Integer默认是0，不会影响no判断
     */
    private Integer baseNo;
    private int flag;
    private String baseName;
    private int fluctuat;

    @Override
    public String toString() {
        return "Base{" +
                "baseNo=" + baseNo +
                ", flag=" + flag +
                ", baseName='" + baseName + '\'' +
                ", fluctuat=" + fluctuat +
                '}';
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getBaseName() {
        return baseName;
    }

    public void setBaseName(String baseName) {
        this.baseName = baseName;
    }

    public int getFluctuat() {
        return fluctuat;
    }

    public void setFluctuat(int fluctuat) {
        this.fluctuat = fluctuat;
    }

    public Integer getBaseNo() {
        return baseNo;
    }

    public void setBaseNo(Integer baseNo) {
        this.baseNo = baseNo;
    }
}
