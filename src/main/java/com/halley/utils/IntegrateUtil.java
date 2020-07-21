package com.halley.utils;

import com.halley.bean.Base;
import com.halley.bean.Item;
import com.halley.bean.ProjectIntegrate;
import com.halley.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 整合工具
 *
 * @author Jan
 * @Date 2020/7/19 21:32
 */
public class IntegrateUtil {



    public static final ProjectIntegrate integrate(Base base) {
        ProjectIntegrate projectIntegrate = new ProjectIntegrate();
        switch (base.getFluctuat()) {
            case 0:
                projectIntegrate.setFluctuat("不影响");
                break;
            case 1:
                projectIntegrate.setFluctuat("增");
                break;
            case -1:
                projectIntegrate.setFluctuat("减");
                break;
            default:
                break;
        }
        projectIntegrate.setId(base.getBaseNo());
        if (base.getFlag() == 1) {
            projectIntegrate.setItemType("导入项目");

        } else {
            projectIntegrate.setItemType("固定项目");
        }
        projectIntegrate.setItemName(base.getBaseName());
        return projectIntegrate;
    }

    public static final ProjectIntegrate integrate(Item item) {
        ApplicationContext ac = new FileSystemXmlApplicationContext("classpath:applicationContext.xml");
        BaseMapper mapper = ac.getBean(BaseMapper.class);
        ProjectIntegrate projectIntegrate = new ProjectIntegrate();
        switch (item.getFluctuat()) {
            case 0:
                projectIntegrate.setFluctuat("不影响");
                break;
            case 1:
                projectIntegrate.setFluctuat("增");
                break;
            case -1:
                projectIntegrate.setFluctuat("减");
                break;
            default:
                break;
        }
        String name = mapper.getBaseNameByItemNo(item.getItemNo());
        projectIntegrate.setFirst(name);
        projectIntegrate.setItemName(item.getItemName());
        projectIntegrate.setItemType("计算项目");
        projectIntegrate.setId(item.getItemNo());
        projectIntegrate.setItemFormula(projectIntegrate.getFirst()+ item.getOperator() + String.valueOf(item.getSecondOp()));
        return projectIntegrate;
    }

    public static final List<ProjectIntegrate> integrateForBase(List<Base> list) {
        List<ProjectIntegrate> integrateList = new ArrayList<>();
        for (Base base : list) {
            integrateList.add(integrate(base));
        }
        return integrateList;
    }

    public static final List<ProjectIntegrate> integrateForItem(List<Item> list) {
        List<ProjectIntegrate> integrateList = new ArrayList<>();
        for (Item item : list) {
            integrateList.add(integrate(item));
        }
        return integrateList;
    }

    public static final Map extractForBase(ProjectIntegrate integrate) {
        ApplicationContext ac = new FileSystemXmlApplicationContext("classpath:applicationContext.xml");
        BaseMapper mapper = ac.getBean(BaseMapper.class);
        Map map = new HashMap();
        Base base = new Base();
        Item item = new Item();
        System.out.println(integrate);
        if ("导入项目".equals(integrate.getItemType())) {
            char op = integrate.getItemFormula().charAt(0);
            System.out.println(op);
            if (op =='+' || op == '-' || op == '*' || op == '/') {
                integrate.setFirst(integrate.getItemName());
                base.setBaseName(integrate.getItemName());
                base.setFlag(1);
                String flu = integrate.getFluctuat();
                if(flu!=null) {
                    switch (flu) {
                        case "增": {
                            base.setFluctuat(1);
                            item.setFluctuat(1);
                        }
                        break;
                        case "减": {
                            base.setFluctuat(-1);
                            item.setFluctuat(-1);
                        }
                        break;
                        case "无影响": {
                            base.setFluctuat(0);
                            item.setFluctuat(0);
                        }
                        break;
                        default:
                            break;
                    }
                }
                item.setBaseNo(mapper.getBaseNoByBaseName(integrate.getItemName()));
                item.setOperator(op);
                item.setSecondOp(Double.valueOf(integrate.getItemFormula().split("\\" + String.valueOf(op))[1]));
                item.setItemName(integrate.getItemName());
                map.put("item", item);
                map.put("import", base);
            }else {
                integrate.setFirst(integrate.getItemName());
                base.setBaseName(integrate.getItemName());
                base.setFlag(1);
                String flu = integrate.getFluctuat();
                if(flu!=null) {
                    switch (flu) {
                        case "增": {
                            base.setFluctuat(1);
                        }
                        break;
                        case "减": {
                            base.setFluctuat(-1);
                        }
                        break;
                        case "无影响": {
                            base.setFluctuat(0);
                        }
                        break;
                        default:
                            break;
                    }
                }
                map.put("import",base);
            }
        } else if ("固定项目".equals(integrate.getItemType())) {
            base.setBaseNo(integrate.getId());
            base.setBaseName(integrate.getItemName());
            base.setFlag(0);
            String flu = integrate.getFluctuat();
            if(flu!=null) {
                switch (flu) {
                    case "增": {
                        base.setFluctuat(1);
                        item.setFluctuat(1);
                    }
                    break;
                    case "减": {
                        base.setFluctuat(-1);
                        item.setFluctuat(-1);
                    }
                    break;
                    case "无影响": {
                        base.setFluctuat(0);
                        item.setFluctuat(0);
                    }
                    break;
                    default:
                        break;
                }
            }
            map.put("base", base);
        } else {
            char op = integrate.getItemFormula().charAt(0);
            item.setOperator(op);
            item.setSecondOp(Double.valueOf(integrate.getItemFormula().split("\\" + String.valueOf(op))[1]));
            item.setItemName(integrate.getItemName());
            String flu = integrate.getFluctuat();
            if(flu!=null) {
                switch (flu) {
                    case "增": {
                        item.setFluctuat(1);
                    }
                    break;
                    case "减": {
                        item.setFluctuat(-1);
                    }
                    break;
                    case "无影响": {
                        item.setFluctuat(0);
                    }
                    break;
                    default:
                        break;
                }
            }
            item.setBaseNo(mapper.getBaseNoByBaseName(integrate.getItemName()));

            map.put("item", item);
        }
        return map;
}


    public static final Map extractForAllItemSimple(ProjectIntegrate integrate){
        Map map = new HashMap();
        if ("固定项目".equals(integrate.getItemType())){
            Base base = new Base();
            base.setBaseNo(integrate.getId());
            base.setFlag(0);
            map.put("base",base);
        }else if("导入项目".equals(integrate.getItemType())){
            Base base = new Base();
            base.setFlag(1);
            base.setBaseNo(integrate.getId());
            map.put("import",base);
        }else {
            Item item = new Item();
            item.setItemNo(integrate.getId());
            map.put("item",item);
        }
        return map;


    }
}
