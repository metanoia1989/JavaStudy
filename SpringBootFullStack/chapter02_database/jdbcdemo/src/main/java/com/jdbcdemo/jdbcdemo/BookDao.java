package com.jdbcdemo.jdbcdemo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

// 数据库访问层
@Repository
public class BookDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    
    public int addBook(Book book) {
        String sql = "INSERT INTO book(name, author) VALUES (?, ?)";
        return jdbcTemplate.update(sql, book.getName(), book.getAuthor());
    }
    
    public int updateBook(Book book) {
        String sql = "UPDATE book SET name=?, author=? WHERE id=?";
        return jdbcTemplate.update(sql, book.getName(), book.getAuthor(), book.getId());
    }
    
    public int deleteBookById(Integer id) {
        String sql = "DELETE FROM book WHERE id=?";
        return jdbcTemplate.update(sql, id);
    }

    public Book getBookById(Integer id) {
        String sql = "SELECT * FROM book WHERE id=?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Book.class), id);
    }
    
    public List<Book> getAllBooks() {
        String sql = "SELECT * FROM book";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Book.class));
    }
}
