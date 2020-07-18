package com.halley.bean;

/**
 * @author Jan
 * @Date 2020/7/18 21:42
 */
public class Item {
    private Integer itemNo;
    private String itemName;
    private Integer baseNo;
    private char operator;
    private double secondOp;
    private int fluctuat;

    @Override
    public String toString() {
        return "Item{" +
                "itemNo=" + itemNo +
                ", itemName='" + itemName + '\'' +
                ", baseNo=" + baseNo +
                ", operator=" + operator +
                ", secondOp=" + secondOp +
                ", fluctuat=" + fluctuat +
                '}';
    }

    public Integer getItemNo() {
        return itemNo;
    }

    public void setItemNo(Integer itemNo) {
        this.itemNo = itemNo;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getBaseNo() {
        return baseNo;
    }

    public void setBaseNo(Integer baseNo) {
        this.baseNo = baseNo;
    }

    public char getOperator() {
        return operator;
    }

    public void setOperator(char operator) {
        this.operator = operator;
    }

    public double getSecondOp() {
        return secondOp;
    }

    public void setSecondOp(double secondOp) {
        this.secondOp = secondOp;
    }

    public int getFluctuat() {
        return fluctuat;
    }

    public void setFluctuat(int fluctuat) {
        this.fluctuat = fluctuat;
    }
}
