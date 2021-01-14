package com.cronjob.cronjob.job;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class MyFirstJob {
    public void sayHello() {
        System.out.println("MyFirstJob:sayHello:" + new Date());
    } 
}
