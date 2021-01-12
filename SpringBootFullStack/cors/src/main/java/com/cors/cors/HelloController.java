package com.cors.cors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    Hello hello;
    
    @GetMapping("/hello")
    public String hello() {
        return hello.sayHello("Adam Smith");
    }   
}
