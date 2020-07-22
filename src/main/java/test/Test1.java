package test;


import com.halley.bean.BaseForJson;
import com.halley.bean.BaseIntegrate;
import com.halley.bean.ImportForJson;
import com.halley.bean.ProjectIntegrate;
import com.halley.mapper.AdminMapper;
import com.halley.mapper.BaseMapper;
import com.halley.mapper.ImportMapper;
import com.halley.service.BaseManageService;
import com.halley.service.ImportManageService;
import com.halley.service.SalaryProjectService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLException;
import java.util.List;

/**
 * @author 17672
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class Test1 {
    @Autowired
    BaseMapper baseMapper;

    @Autowired
    AdminMapper adminMapper;

    @Autowired
    SalaryProjectService salaryProjectService;

    @Autowired
    BaseManageService baseManageService;

    @Test
    public void test1() throws SQLException {
        String baseFlagByItemNo = baseMapper.getBaseNameByItemNo(1);
        System.out.println(baseFlagByItemNo+"--------------------------");
    }


    @Test
    public void test2(){
        System.out.println(adminMapper.getAdminByUsername("admin"));
    }

    @Test
    public void test3(){
        String s = null;
        System.out.println(s==null);
    }

    @Test
    public void test4(){
        ProjectIntegrate projectIntegrate = new ProjectIntegrate();
        projectIntegrate.setItemName("事假");
        List<ProjectIntegrate> salaryProjectByCondition = salaryProjectService.getSalaryProjectByCondition(projectIntegrate);
        System.out.println(salaryProjectByCondition);
    }

    @Test
    public void test5(){
        ProjectIntegrate projectIntegrate = new ProjectIntegrate();
        List<ProjectIntegrate> salaryProjectByCondition = salaryProjectService.getSalaryProjectByCondition(projectIntegrate);
        System.out.println(salaryProjectByCondition);
    }

    @Test
    public void test6(){
        String a = "+213";
        System.out.println(a.split("\\+")[1] +"-----------------------------------");

    }

    @Test
    public void test7(){
        ProjectIntegrate projectIntegrate = new ProjectIntegrate();
        projectIntegrate.setItemFormula("2000");
        projectIntegrate.setItemName("水暖补贴");
        projectIntegrate.setItemType("固定项目");
        projectIntegrate.setFluctuat("增");
        salaryProjectService.insertItem(projectIntegrate);
    }

    @Test public void test8(){
        ProjectIntegrate projectIntegrate = new ProjectIntegrate();
        projectIntegrate.setItemName("病假");
        projectIntegrate.setItemType("导入项目");
        projectIntegrate.setFluctuat("减");
        projectIntegrate.setItemFormula("*20");
        projectIntegrate.setFirst("病假");
        salaryProjectService.insertItem(projectIntegrate);
    }

    @Test
    public void test9(){
        String name = baseMapper.getBaseNameByItemNo(2);
        System.out.println(name);
    }
    @Test
    public void test10(){
        List<BaseForJson> baseRecByCondition = baseManageService.getBaseRecByCondition(new BaseIntegrate());
        System.out.println(baseRecByCondition+"-----------------------------");
        System.out.println(baseRecByCondition+"-----------------------------");

        System.out.println(baseRecByCondition+"-----------------------------");

    }

    @Autowired
    ImportManageService importManageService;
    @Test
    public void test11() {
        List<ImportForJson> importForJson = importManageService.getImportForJson(new ImportForJson());
        System.out.println(importForJson);
    }
}
