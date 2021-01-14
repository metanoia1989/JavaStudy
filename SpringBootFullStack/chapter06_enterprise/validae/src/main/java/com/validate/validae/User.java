package com.validate.validae;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class User {
    private Integer id; 
    
    @Size(min = 5, max = 10, message = "{user.name.size}", groups = ValidationGroup1.class)
    private String name;
    
    @NotNull(message = "{user.address.notnull}", groups = ValidationGroup2.class)
    private String address;
    
    @DecimalMin(value = "1", message = "{user.age.size}")
    @DecimalMax(value = "200", message = "{user.age.size}")
    private Integer age;
    
    @Email(message = "{user.email.pattern}")
    @NotNull(message = "{user.email.notnull}", groups = ValidationGroup2.class )
    private String email;

}
