package com.halley.bean;

import org.springframework.stereotype.Component;

/**
 * @author Jan
 * @Date 2020/7/18 21:52
 */
@Component
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
