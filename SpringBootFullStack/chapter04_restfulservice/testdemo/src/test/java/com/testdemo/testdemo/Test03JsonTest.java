package com.testdemo.testdemo;

import com.testdemo.testdemo.model.Book;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;

// 测试 Json 序列化和反序列化是否正常工作
@RunWith(SpringRunner.class)
@JsonTest
public class Test03JsonTest {
    @Autowired 
    JacksonTester<Book> jacksonTester;
    
    @Test
    public void testSerialize() throws Exception {
        Book book = new Book(); 
        book.setId(1);
        book.setName("三国演义");
        book.setAuthor("罗贯中");
        Assertions.assertThat(jacksonTester.write(book))
            .isEqualToJson("book.json");
        Assertions.assertThat(jacksonTester.write(book))
            .hasJsonPathStringValue("@.name");
        Assertions.assertThat(jacksonTester.write(book))
            .extractingJsonPathStringValue("@.name")
            .isEqualTo("三国演义");
    }
    
    @Test
    public void testDeserialize() throws Exception{
        String content =  "{\"id\": 1, \"name\": \"三国演义\", \"author\": \"罗贯中\"}";
        Assertions.assertThat(jacksonTester.parseObject(content).getName())
            .isEqualTo("三国演义");
    }
}
