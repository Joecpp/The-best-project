package com.halley.mapper;

import com.halley.bean.Item;
import com.halley.bean.ItemRec;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Jan
 * @Date 2020/7/20 20:11
 */
@Repository
public interface ItemMapper {
    /**
     * 根据项目名获得计算项目
     * @param ItemName
     * @return
     */
    Item getItemByItemName(String ItemName);

    /**
     * 获得所有计算项目
     * @return
     */
    List<Item> getAllItem();

    /**
     * 插入计算项目
     * @param item
     */
    void insertItem(Item item);

    /**
     * 更新Item
     * @param item
     */
    void updateItem(Item item);

    /**
     * 删除项目

     * @param itemNo
     */
    void deleteItem(Integer itemNo);

    /**
     * 根据基本项目查找
     * @param baseNo
     * @return
     */
    Item getItemByBaseNo(Integer baseNo);

    /**
     * 获得Item具体项目
     * @param empNo
     * @return
     */
    ItemRec getItemRecByEmpNo(Integer empNo);
}
