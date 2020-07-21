package com.halley.service;

import com.halley.bean.Base;
import com.halley.bean.Item;
import com.halley.bean.ProjectIntegrate;
import com.halley.mapper.BaseMapper;
import com.halley.mapper.ItemMapper;
import com.halley.mapper.SalaryProjectCombineMapper;
import com.halley.utils.IntegrateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    @Autowired
    SalaryProjectCombineMapper combineMapper;

    /**
     * 根据条件返回需要的工资项目
     *
     * @param projectIntegrate
     * @return
     */
    public List<ProjectIntegrate> getSalaryProjectByCondition(ProjectIntegrate projectIntegrate) {
        String itemName = projectIntegrate.getItemName();
        String itemType = projectIntegrate.getItemType();
        List list = new ArrayList();

        if ("".equals(itemName) && "".equals(itemType)) {
            List<Base> allBase = baseMapper.getAllBase();
            List<Item> allItem = itemMapper.getAllItem();
            list.addAll(IntegrateUtil.integrateForBase(allBase));
            list.addAll(IntegrateUtil.integrateForItem(allItem));
        } else if (!"".equals(itemName)) {
            Base baseByProjectName = baseMapper.getBaseByProjectName(itemName);
            if (baseByProjectName == null) {
                Item itemByItemName = itemMapper.getItemByItemName(itemName);
                list.add(IntegrateUtil.integrate(itemByItemName));
            } else {
                list.add(IntegrateUtil.integrate(baseByProjectName));
            }

        } else {
            switch (itemType) {
                case "固定项目":
                    list.addAll(IntegrateUtil.integrateForBase(baseMapper.getBaseByFlag(0)));
                    break;
                case "导入项目":
                    list.addAll(IntegrateUtil.integrateForBase(baseMapper.getBaseByFlag(1)));
                    break;
                case "计算项目":
                    list.addAll(IntegrateUtil.integrateForItem(itemMapper.getAllItem()));
                default:
                    break;
            }
        }

        return list;
    }

    /**
     * 新增工资项目
     * @param projectIntegrate
     */
    @Transactional(rollbackFor=Exception.class)
    public void insertItem(ProjectIntegrate projectIntegrate) {
        Map map = IntegrateUtil.extractForBase(projectIntegrate);
        Base base = (Base) map.get("base");
        Item item = (Item) map.get("item");
        Base anImport = (Base) map.get("import");
        System.out.println(base);
        System.out.println(anImport);
        System.out.println(item);
        if (base != null) {
            combineMapper.insertBase(base);
        } else if (anImport != null && item == null) {
            combineMapper.insertBase(anImport);
        } else if (anImport != null && item != null) {
            combineMapper.insertBase(anImport);
            Integer baseNoByBaseName = baseMapper.getBaseNoByBaseName(anImport.getBaseName());
            item.setBaseNo(baseNoByBaseName);
            itemMapper.insertItem(item);
        }else {
            item.setBaseNo(baseMapper.getBaseNoByBaseName(projectIntegrate.getFirst()));

            itemMapper.insertItem(item);
        }
    }

    /**
     * 获得项目名
     * @return
     */
    public List<String> getProjectName(){
        List<String> allBaseName = baseMapper.getAllBaseName();

        return allBaseName;
    }

    /**
     * 更新项目
     * @param projectIntegrate
     */
    public void updateBase(ProjectIntegrate projectIntegrate){
        Map map = IntegrateUtil.extractForBase(projectIntegrate);
        Base anImport = (Base) map.get("import");
        Base base = (Base) map.get("base");
        Item item = (Item) map.get("item");
        if(anImport!=null){
            baseMapper.updateBase(base);
        }else if(base!=null){
            baseMapper.updateBase(base);
        }else {
            itemMapper.updateItem(item);
        }

    }

    /**
     * 删除项目
     * @param projectIntegrate
     */
    public String deleteProject(ProjectIntegrate projectIntegrate){
        Map map = IntegrateUtil.extractForAllItemSimple(projectIntegrate);
        Base anImport = (Base) map.get("import");
        Base base = (Base) map.get("base");
        Item item = (Item) map.get("item");
        String msg = null;
        if(anImport!=null){
            try {
                baseMapper.deleteBase(anImport.getBaseNo());
            }catch (Exception e){
                msg = "请删除跟这个项目有关的计算项目";
            }
        }else if(base!=null){
            try {
                baseMapper.deleteBase(base.getBaseNo());
        }catch (Exception e){
            msg = "请删除跟这个项目有关的计算项目";
        }
        }else {
            itemMapper.deleteItem(item.getItemNo());
        }
        return msg;
    }
}