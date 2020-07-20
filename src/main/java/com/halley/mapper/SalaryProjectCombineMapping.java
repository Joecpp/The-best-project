package com.halley.mapper;

import com.halley.bean.ItemIntegrate;

/**
 * @author Jan
 * @Date 2020/7/20 19:48
 */
public interface SalaryProjectCombineMapping {
    /**
     * 按照条件查询工资项目
     * @param itemName
     * @param itemType
     * @return
     */
    ItemIntegrate getSalaryProjectByCondition(String itemName,String itemType);
}
