package com.testdemo.testdemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

// 使用 TestRestTemplate 来实现集成测试
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class Test02Application {
    @Autowired
    TestRestTemplate restTemplate;
    
    @Test
    public void testHello() {
        ResponseEntity<String> hello = restTemplate.getForEntity("/hello?name={0}", 
            String.class, "Michael"); 
        System.out.println(hello.getBody());
    }
}
