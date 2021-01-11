package com.webdemo.controller;

import java.util.Date;

import com.webdemo.model.Book;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// 默认通过 MappingJackson2HttpMessageConverter
// 可以使用 @RestController = @Controller + @ResponseBody
@Controller
public class BookController {

    @GetMapping("/book")    
    @ResponseBody // 响应处理器
    public Book book() {
        Book book = new Book();  
        book.setAuthor("罗贯中");
        book.setName("三国演义");
        book.setPrice(30f);
        book.setPublicationDate(new Date());
        return book;
    }

}
