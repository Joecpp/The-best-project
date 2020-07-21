package com.halley.service;

import com.halley.bean.Dept;
import com.halley.bean.Job;
import com.halley.mapper.DeptMapper;
import com.halley.mapper.JobMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Joe
 * @date 2020/7/21 15:17
 */
@Service
public class JobService {
        @Autowired
        JobMapper jobMapper;

        public List<Job> searchJob(Integer jobNo, String jobName){
            List<Job> list = jobMapper.getByNameAndNo(jobNo,jobName);
            return list;
        }

        public List<Job> getAllJob(){
            List<Job> list = jobMapper.getAllJob();
            return list;
        }

        public boolean addJob(Job job){
            boolean flag = jobMapper.addJob(job);
            return flag;
        }

        public boolean updateJob(Job job){
            boolean flag = jobMapper.updateJob(job);
            return flag;
        }

        public boolean deleteJob(Integer jobNo){
            boolean flag = jobMapper.deleteJob(jobNo);
            return flag;
        }

        /**
         * 批量删除部门
         * @param list
         * @return 删除成功的个数
         */
        public Integer deleteMultiJob(List<Job> list){
            Integer num = 0;
            if (list != null) {
                for (Job job:
                        list) {
                    if (jobMapper.deleteJob(job.getJobNo()) == true) {
                        num++;
                    }
                }
            }
            return num;
        }

        public boolean isRepeat(Job job){
            List<Job> list = jobMapper.getAllJob();
            boolean flag = false;
            if(list.isEmpty()){

            }else {
                for (Job tmp:list) {
                    if (job.getJobNo()==tmp.getJobNo()){
                        flag = true;
                    }
                }
            }
            return flag;
        }
}
