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

    private String first;

    private String newName;

    @Override
    public String toString() {
        return "ProjectIntegrate{" +
                "id=" + id +
                ", itemName='" + itemName + '\'' +
                ", first='" + first + '\'' +
                ", newName='" + newName + '\'' +
                ", itemType='" + itemType + '\'' +
                ", itemFormula='" + itemFormula + '\'' +
                ", fluctuat='" + fluctuat + '\'' +
                '}';
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }


    private String itemType;
    /**
     * 整合后的公式
     */
    private String itemFormula;

    /**
     * 增减项
     */
    private String fluctuat;

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

    public String getFluctuat() {
        return fluctuat;
    }

    public void setFluctuat(String fluctuat) {
        this.fluctuat = fluctuat;
    }
}
