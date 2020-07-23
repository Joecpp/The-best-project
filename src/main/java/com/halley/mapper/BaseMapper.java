package com.halley.mapper;

import com.halley.bean.Base;
import com.halley.bean.BaseRec;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Import;
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

    /**
     * 根据项目名获取项目id
     * @param name
     * @return
     */
    Integer getBaseNoByBaseName(String name);

    /**
     * 获得所有baseName
     * @return
     */
    List<String> getAllBaseName();

    /**
     * 更新Base
     * @param base
     */
    void updateBase(Base base);

    /**
     * 删除项目
     * @param baseNo
     */
    void deleteBase(Integer baseNo);

    /**
     * 获得
     * @param baseNo
     * @return
     */
    String getBaseNameByBaseNo(Integer baseNo);

    /**
     * byFlag0
     * @param baseNo
     * @return
     */
    String getBaseNameByBaseNo1(Integer baseNo);

    /**
     * 没有其他条件
     * @param baseNo
     * @return
     */
    Base getBaseByBaseNo(Integer baseNo);
    /**
     * byFlag1
     * @param flag
     * @return
     */
    List<String> getBaseNameByFlag(int flag);

    /**
     * 获得部门固定工资
     * @param deptNo
     * @return
     */
    List<BaseRec> getBaseRecByDeptNo(Integer deptNo);
}
