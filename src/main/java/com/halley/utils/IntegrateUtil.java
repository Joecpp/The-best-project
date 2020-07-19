package com.halley.utils;

import com.halley.bean.Base;
import com.halley.bean.Item;
import com.halley.bean.ItemIntegrate;
import com.halley.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 整合工具
 * @author Jan
 * @Date 2020/7/19 21:32
 */
public class IntegrateUtil {
    @Autowired
    static BaseMapper baseMapper;

    public static final ItemIntegrate integrate(Base base){
        ItemIntegrate itemIntegrate = new ItemIntegrate();
        itemIntegrate.setFluctuat(base.getFluctuat());
        itemIntegrate.setId(base.getBaseNo());
        if (base.getFlag()==1) {
            itemIntegrate.setItemType("导入项目");

        }else {
            itemIntegrate.setItemType("固定项目");
        }
        itemIntegrate.setItemName(base.getBaseName());
        return itemIntegrate;
    }

    public static final ItemIntegrate integrate(Item item){
        ItemIntegrate itemIntegrate = new ItemIntegrate();
        String name = baseMapper.getBaseNameByItemNo(item.getItemNo());
        itemIntegrate.setItemName(item.getItemName());
        itemIntegrate.setBaseName(name);
        itemIntegrate.setItemType("计算项目");
        itemIntegrate.setId(item.getItemNo());
        itemIntegrate.setItemFormula(item.getOperator()+String.valueOf(item.getSecondOp()));
        return itemIntegrate;

    }
}
