package com.redisdemo.redisdemo.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Book implements Serializable {
    private Integer id; 
    private String name; 
    private String author; 
}
