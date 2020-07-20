package com.halley.bean;

/**
 * 整合项目的工具Bean
 *
 * @author 17672
 */
public class ProjectIntegrate {
    /**
     * id
     */
    private Integer id;
    /**
     * 整合后的项目名
     */
    private String itemName;

    @Override
    public String toString() {
        return "ItemIntegrate{" +
                "id=" + id +
                ", itemName='" + itemName + '\'' +
                ", itemType='" + itemType + '\'' +
                ", itemFormula='" + itemFormula + '\'' +
                ", fluctuat=" + fluctuat +
                '}';
    }


    private int itemType;
    /**
     * 整合后的公式
     */
    private String itemFormula;

    /**
     * 增减项
     */
    private int fluctuat;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemType() {
        return itemType;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    public String getItemFormula() {
        return itemFormula;
    }

    public void setItemFormula(String itemFormula) {
        this.itemFormula = itemFormula;
    }

    public int getFluctuat() {
        return fluctuat;
    }

    public void setFluctuat(int fluctuat) {
        this.fluctuat = fluctuat;
    }
}
