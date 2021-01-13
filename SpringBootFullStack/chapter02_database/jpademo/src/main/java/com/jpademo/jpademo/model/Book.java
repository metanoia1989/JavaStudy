package com.jpademo.jpademo.model;

import javax.persistence.*;

import lombok.Data;

@Entity(name = "t_book")
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "book_name", nullable = false)
    private String name;
    
    private String author; 
    private Float price; 
        
    @Transient
    private String description;

}
