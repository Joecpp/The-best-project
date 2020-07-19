package com.halley.bean;

/**
 * 整合项目的工具Bean
 *
 * @author 17672
 */
public class ItemIntegrate {
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
                ", baseType='" + baseName + '\'' +
                ", itemType='" + itemType + '\'' +
                ", itemFormula='" + itemFormula + '\'' +
                ", fluctuat=" + fluctuat +
                '}';
    }

    public String getBaseName() {
        return baseName;
    }

    public void setBaseName(String baseName) {
        this.baseName = baseName;
    }

    /**
     * 类型
     */

    private String baseName;

    private String itemType;
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

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
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
