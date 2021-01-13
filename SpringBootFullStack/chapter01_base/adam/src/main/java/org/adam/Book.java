package org.adam;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix = "book")
public class Book {
    private String name; 
    private String author; 
    private Float price; 
}
