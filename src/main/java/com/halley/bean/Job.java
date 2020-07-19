package com.halley.bean;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @author Jan
 * @Date 2020/7/18 21:52
 */
@Repository
public class Job {
    private Integer jobNo;
    private String jobName;
    private String jobInfo;

    @Override
    public String toString() {
        return "Job{" +
                "jobNo=" + jobNo +
                ", jobName='" + jobName + '\'' +
                ", jobInfo='" + jobInfo + '\'' +
                '}';
    }

    public Job(Integer jobNo, String jobName, String jobInfo) {
        this.jobNo = jobNo;
        this.jobName = jobName;
        this.jobInfo = jobInfo;
    }

    public Job() {
    }

    public Job(String jobName) {
        this.jobName = jobName;
    }



    public Integer getJobNo() {
        return jobNo;
    }

    public void setJobNo(Integer jobNo) {
        this.jobNo = jobNo;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobInfo() {
        return jobInfo;
    }

    public void setJobInfo(String jobInfo) {
        this.jobInfo = jobInfo;
    }
}
