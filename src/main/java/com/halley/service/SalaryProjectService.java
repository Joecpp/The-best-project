package com.halley.service;

import com.halley.bean.Base;
import com.halley.bean.Item;
import com.halley.bean.ProjectIntegrate;
import com.halley.mapper.BaseMapper;
import com.halley.mapper.ItemMapper;
import com.halley.utils.IntegrateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jan
 * @Date 2020/7/20 20:38
 */
@Service
public class SalaryProjectService {
    @Autowired
    BaseMapper baseMapper;

    @Autowired
    ItemMapper itemMapper;
    /**
     * 根据条件返回需要的工资项目
     * @param projectIntegrate
     * @return
     */
    public List<ProjectIntegrate> getSalaryProjectByCondition(ProjectIntegrate projectIntegrate){
        String itemName = projectIntegrate.getItemName();
        int itemType = projectIntegrate.getItemType();
        List list = new ArrayList();
        if(itemName==null && itemType==0){
            List<Base> allBase = baseMapper.getAllBase();
            List<Item> allItem = itemMapper.getAllItem();
            list.addAll(IntegrateUtil.integrateForBase(allBase));
            list.addAll(IntegrateUtil.integrateForItem(allItem));
        }else if (itemName!=null){
            Base baseByProjectName = baseMapper.getBaseByProjectName(itemName);
            if(baseByProjectName==null){
                Item itemByItemName = itemMapper.getItemByItemName(itemName);
                list.add(IntegrateUtil.integrate(itemByItemName));
            }else {
                list.add(IntegrateUtil.integrate(baseByProjectName));
            }

        }else {
            switch (itemType){
                case 1:list.addAll(IntegrateUtil.integrateForBase(baseMapper.getBaseByFlag(0)));break;
                case 2:list.addAll(IntegrateUtil.integrateForBase(baseMapper.getBaseByFlag(1)));break;
                case 3:list.addAll(IntegrateUtil.integrateForItem(itemMapper.getAllItem()));
                default:break;
            }
        }

        return list;
    }
}
