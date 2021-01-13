package org.adam;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix = "my")
public class User {
    private String name; 
    private String address; 
    private List<String> favorites; 
}
