package com.halley.mapper;

import com.halley.bean.Job;

import org.apache.ibatis.annotations.Param;

import org.springframework.stereotype.Component;

import java.util.List;

@Component

public interface JobMapper {

    /**
     * 查询所有部门
     * @return 返回所有部门的封装list对象
     */
    public List<Job> getAllJob();

    /**
     * 岗位编号返回岗位
     * @param jobNo 岗位编号
     * @return 返回编号对应的岗位
     */
    public Job getByNo(@Param("jobNo") Integer jobNo);

    /**
     * 根据岗位名和岗位编号返回岗位，两参数为null则查询全部岗位
     * @param jobNo
     * @param jobName
     * @return 返回封装的岗位list
     */
    public List<Job> getByNameAndNo(@Param("jobNo") Integer jobNo, @Param("jobName") String jobName);

    /**
     * 根据岗位信息增加岗位
     * @param job
     * @return 是否正确插入
     */
    public boolean addJob(@Param("job") Job job);

    /**
     * 根据新岗位信息更新岗位
     * @param job
     * @return 是否正确更新
     */
    public boolean updateJob(@Param("job") Job job);

    /**
     * 根据岗位号删除岗位
     * @param jobNo
     * @return 是否正确删除
     */
    public boolean deleteJob(@Param("jobNo")Integer jobNo);
}
