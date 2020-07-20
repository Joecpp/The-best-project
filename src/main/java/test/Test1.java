package test;


import com.halley.bean.ProjectIntegrate;
import com.halley.mapper.AdminMapper;
import com.halley.mapper.BaseMapper;
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
}
