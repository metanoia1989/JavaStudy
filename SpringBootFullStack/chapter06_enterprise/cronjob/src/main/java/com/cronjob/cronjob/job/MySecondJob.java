package com.cronjob.cronjob.job;

import java.util.Date;

import org.quartz.JobExecutionContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class MySecondJob extends QuartzJobBean {
    private String name;
    
    public void setName(String name) {
        this.name = name; 
    }
    
    @Override
    protected void executeInternal(JobExecutionContext context) {
        System.out.print("hello: " + name + ":" + new Date());
    }
    
}
