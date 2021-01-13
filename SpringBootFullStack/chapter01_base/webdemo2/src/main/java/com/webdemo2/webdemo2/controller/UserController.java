package com.webdemo2.webdemo2.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.webdemo2.webdemo2.model.Author;
import com.webdemo2.webdemo2.model.Book;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @GetMapping("/hello")
    public ArrayList<String> hello(Model model) {
        Map<String, Object> map = model.asMap();
        Set<String> keySet = map.keySet();
        Iterator<String> iterator = keySet.iterator();
        ArrayList<String> results = new ArrayList<>();
        while (iterator.hasNext()) {
            String key = iterator.next(); 
            Object value = map.get(key);
            // System.out.println(key + ">>>>>" + value);
            results.add(key + ">>>>>>" + value);
        }
        return results;
    } 
    
    // 访问测试 /book?b.name=三国演义&b.author=罗贯中&a.name=曹雪芹&a.age=48
    // 请求参数预处理   
    @GetMapping("/book")
    public String book(@ModelAttribute("b") Book book, @ModelAttribute("a") Author author) {
        return book.toString() + ">>>>" + author.toString();
    }
    
    @GetMapping("/wrong")
    public String wrong() {
        int i = 1/0;
        return "hello";
    }
}
