package Test;

import com.halley.bean.Dept;
import com.halley.bean.Job;
import com.halley.mapper.AdminMapper;
import com.halley.mapper.DeptMapper;
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

    // Test JobMapper
    @Test
    public void JobMapperTest() {
        JobMapper jobMapper = ioc.getBean(JobMapper.class);
        System.out.printf(jobMapper.getAllJob().toString());
//        System.out.printf(jobMapper.getByNo(1).toString());
//        System.out.printf(jobMapper.getByNameAndNo(2, "Java").toString());
//        System.out.printf(jobMapper.addJob(new Job(null, "996岗位", "死得巧不如死得早")) ? "插入" : "失败");
//        System.out.printf(jobMapper.deleteJob(6) ? "删除" : "失败");
    }

    @Test
    public void DeptMapperTest() {
        DeptMapper deptMapper = ioc.getBean(DeptMapper.class);
        System.out.printf(deptMapper.getAllDept().toString());
//        System.out.printf(deptMapper.getByNo(1).toString());
//        System.out.printf(deptMapper.getByNameAndNo(2, "").toString());
//        System.out.printf(deptMapper.addDept(new Dept(null, "天天加班部门", "死得巧不如死得早")) ? "插入" : "失败");
//        System.out.printf(deptMapper.deleteDept(4) ? "删除" : "失败");
    }
}
