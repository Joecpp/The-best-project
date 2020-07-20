package com.halley.mapper;

import com.halley.bean.Item;
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
}
