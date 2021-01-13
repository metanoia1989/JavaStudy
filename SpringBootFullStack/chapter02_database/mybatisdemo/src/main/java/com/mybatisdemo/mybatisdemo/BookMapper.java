package com.mybatisdemo.mybatisdemo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookMapper {
    int addBook(Book book); 
    int deleteBookById(int id);
    int updateBookById(Book book);
    Book getBookById(int id);
    List<Book> getAllBooks();
}
