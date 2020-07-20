package com.halley.mapper;

import com.halley.bean.Base;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用于操作关于基本项目的Mapper
 * @author Jan
 * @Date 2020/7/19 21:47
 */

@Repository
public interface BaseMapper {
    /**
     * 根据计算项目的id获得对应的基本项目
     * @param itemNo
     * @return
     */
    String getBaseNameByItemNo(Integer itemNo);

    /**
     * 按照条件查询工资项目
     * @param itemName
     * @return
     */
    Base getBaseByProjectName(String itemName);

    /**
     * 获得所欲固定项目和导入项目
     * @return
     */
    List<Base> getAllBase();

    /**
     * 根据项目类型获取Base
     * @param flag
     * @return
     */
    List<Base> getBaseByFlag(int flag);
}
