package Test;


import com.alibaba.druid.pool.DruidDataSource;
import com.halley.bean.TestBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class Test {
    //测试SpringIOC容器，及Druid连接池的成功
    @org.junit.Test
    public void test1() throws SQLException {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.printf(ioc.getBean(TestBean.class).toString());
        DruidDataSource druidDataSource = ioc.getBean(DruidDataSource.class);
        System.out.printf(druidDataSource.getConnection().toString());
    }
}
