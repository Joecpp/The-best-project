package Test;

import com.halley.mapper.AdminMapper;
import com.halley.mapper.JobMapper;
import com.halley.service.JobService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Joe
 * @date 2020/7/19 10:02
 */
public class Test_joe {
    ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
    @Test
    public void test1(){
        System.out.printf(ioc.getBean(JobMapper.class).getAllJob().toString());
    }
}
