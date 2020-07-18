package com.halley.bean;

/**
 * @author Jan
 * @Date 2020/7/18 21:52
 */
public class Job {
    private int jobNo;
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

    public int getJobNo() {
        return jobNo;
    }

    public void setJobNo(int jobNo) {
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
