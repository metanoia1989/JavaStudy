package com.restdemo.restdemo.repository;

import java.util.List;

import com.restdemo.restdemo.model.Book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

// JpaRepository提供了基本的增删改查、分页查询方法
@RepositoryRestResource(path = "books", collectionResourceRel = "books-key",
    itemResourceRel = "item-url" )
// @RepositoryRestResource(exported = false) // 屏蔽所有增删改查接口
public interface BookRepository extends JpaRepository<Book, Integer> {
    @RestResource(path = "author", rel = "author")
    List<Book> findByAuthorContains(@Param("author") String author);

    @RestResource(path = "name", rel = "name")
    List<Book> findByNameEquals(@Param("name") String name);
    
    @Override
    @RestResource(exported = false) // 只屏蔽删除接口
    void deleteById(Integer integer);
}
