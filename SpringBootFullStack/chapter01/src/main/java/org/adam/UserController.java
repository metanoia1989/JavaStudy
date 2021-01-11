package org.adam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired 
    Users users;
    
    @GetMapping("/users")
    public String book() {
        return users.toString();
    }
}
