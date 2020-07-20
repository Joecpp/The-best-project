package com.halley.utils;

import com.halley.bean.Base;
import com.halley.bean.Item;
import com.halley.bean.ProjectIntegrate;
import com.halley.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * 整合工具
 * @author Jan
 * @Date 2020/7/19 21:32
 */
public class IntegrateUtil {
    @Autowired
    static BaseMapper baseMapper;

    public static final ProjectIntegrate integrate(Base base){
        ProjectIntegrate projectIntegrate = new ProjectIntegrate();
        switch (base.getFluctuat()){
         case 0 : projectIntegrate.setFluctuat("不影响");break;
            case 1:projectIntegrate.setFluctuat("增");break;
            case -1:projectIntegrate.setFluctuat("减");break;
            default:break;
        }
        projectIntegrate.setId(base.getBaseNo());
        if (base.getFlag()==1) {
            projectIntegrate.setItemType("导入项目");

        }else {
            projectIntegrate.setItemType("固定项目");
        }
        projectIntegrate.setItemName(base.getBaseName());
        return projectIntegrate;
    }

    public static final ProjectIntegrate integrate(Item item){
        ProjectIntegrate projectIntegrate = new ProjectIntegrate();
        switch (item.getFluctuat()){
            case 0 : projectIntegrate.setFluctuat("不影响");break;
            case 1:projectIntegrate.setFluctuat("增");break;
            case -1:projectIntegrate.setFluctuat("减");break;
            default:break;
        }
        projectIntegrate.setItemName(item.getItemName());
        projectIntegrate.setItemType("计算项目");
        projectIntegrate.setId(item.getItemNo());
        projectIntegrate.setItemFormula(item.getOperator()+String.valueOf(item.getSecondOp()));
        return projectIntegrate;
    }

    public static final List<ProjectIntegrate> integrateForBase(List<Base> list){
        List<ProjectIntegrate> integrateList = new ArrayList<>();
        for(Base base:list){
            integrateList.add(integrate(base));
        }
        return integrateList;
    }

    public static final List<ProjectIntegrate> integrateForItem(List<Item> list){
        List<ProjectIntegrate> integrateList = new ArrayList<>();
        for(Item item:list){
            integrateList.add(integrate(item));
        }
        return integrateList;
    }
}
