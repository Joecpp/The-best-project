package com.halley.mapper;

import com.halley.bean.Base;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * 用于操作关于基本项目的Mapper
 * @author Jan
 * @Date 2020/7/19 21:47
 */

@Component
public interface BaseMapper {
    /**
     * 根据计算项目的id获得对应的基本项目
     * @param itemNo
     * @return
     */
    String getBaseNameByItemNo(Integer itemNo);
}
