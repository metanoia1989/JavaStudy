package com.restdemo.restdemo.repository;

import com.restdemo.restdemo.model.Book;

import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository提供了基本的增删改查、分页查询方法
public interface BookRepository extends JpaRepository<Book, Integer> {
}
