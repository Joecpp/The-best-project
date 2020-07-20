package test;


import com.halley.mapper.AdminMapper;
import com.halley.mapper.BaseMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLException;

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

    @Test
    public void test1() throws SQLException {
        String baseFlagByItemNo = baseMapper.getBaseNameByItemNo(1);
        System.out.println(baseFlagByItemNo+"--------------------------");
    }


    @Test
    public void test2(){
        System.out.println(adminMapper.getAdminByUsername("admin"));
    }
}
