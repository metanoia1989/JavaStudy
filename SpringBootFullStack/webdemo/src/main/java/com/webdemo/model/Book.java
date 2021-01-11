package com.webdemo.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

//*************************************************************************
// spring-boot-starter-web 默认把 jackson-databind 作为JSON处理器，
// 不需要额外的处理器，就能返回一段JSON   
//*************************************************************************

@Data
public class Book {
    private String name;    
    private String author;    
    
    @JsonIgnore 
    private Float price;
    
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date publicationDate;
}
