package com.cors.cors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {
    @PostMapping("/")
    @CrossOrigin(value = "http://localhost:8080", maxAge = 1800, allowedHeaders = "*")
    public String addBookString(String name) {
        return "receive:" + name; 
    }
    
    @DeleteMapping("/{id}")
    public String deleteBookById(@PathVariable Long id) {
        return String.valueOf(id); 
    }
}
