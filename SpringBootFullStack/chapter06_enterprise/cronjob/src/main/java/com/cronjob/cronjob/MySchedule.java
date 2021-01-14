package com.cronjob.cronjob;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MySchedule {
    @Scheduled(fixedDelay = 1000)    
    public void fixedDelay() {
        System.out.println("fixedDelay: " + new Date()); 
    }
    
    @Scheduled(fixedRate = 2000)
    public void fixedRate() {
        System.out.println("fixedRate: " + new Date()); 
    }
    
    @Scheduled(initialDelay = 1000, fixedRate = 2000)
    public void initialDelay() {
        System.out.println("initialDelay: " + new Date()); 
    }
    
    @Scheduled(cron = "0 * * * * ?") // 每分钟执行一次
    public void cron() {
        System.out.println("cron: " + new Date()); 
    }
}
