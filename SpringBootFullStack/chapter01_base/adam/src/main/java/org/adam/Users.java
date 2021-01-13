package org.adam;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@ConfigurationProperties(prefix = "another")
public class Users {
    private List<UserItem> users; 
}

@Data
class UserItem {
    private String name; 
    private String address; 
    private List<String> favorites; 
}

