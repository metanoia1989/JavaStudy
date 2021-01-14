package com.validate.validae;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @PostMapping("/user") 
    public List<String> addUser(@Validated(ValidationGroup2.class) User user, BindingResult result) {
        List<String> errors = new ArrayList<>();
        if (result.hasErrors()) {
            List<ObjectError> allErrors = result.getAllErrors();
            for (ObjectError error : allErrors) {
                errors.add(error.getDefaultMessage()); 
            }
        }
        return errors;
    }
}
