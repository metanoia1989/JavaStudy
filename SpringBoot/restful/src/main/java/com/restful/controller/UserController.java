package com.restful.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.restful.domain.User;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "用户管理")    
@RestController
@RequestMapping(value = "/users")
public class UserController {
    // 创建线程安全的Map，模拟users信息的存储
    static Map<Long, User> users = Collections.synchronizedMap(new HashMap<Long, User>()); 
    
    /** 
     * 处理 "/users/"的GET请求，用来获取用户列表
     * 
     * @return 
     */
    @ApiOperation("用户列表")
    @GetMapping("/")
    public List<User> getUserList() {
        // 还可以通过 @RequestParam 从页面中传递参数来进行查询条件或者翻页信息的传递
        List<User> r = new ArrayList<User>(users.values());
        return r;
    }
    
    /**
     * 处理 "/users/{id}" 的GET请求，用来获取url中id值的User信息
     *
     * @param id
     * @return
     */ 
    @ApiOperation("用户详情")
    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        // url 中的id可通过@PathVariable绑定到函数的参数中
        return users.get(id);
    }

    /**
     * 处理 "/users/" 的POST请求，用来创建User
     *
     * @param user
     * @return
     */ 
    @ApiOperation("创建用户")
    @PostMapping("/")
    public String postUser(@RequestBody User user) {
        // @RequestBody 注解用来绑定通过http请求中application/json类型上传的数据
        users.put(user.getId(), user);
        return "success";
    }
    
    /** 
     * 处理"/users/{id}"的PUT请求，用来更新User信息
     *
     * @param id
     * @param user
     * @return
     */
    @ApiOperation("更新用户")
    @PutMapping("/{id}")
    public String putUser(@PathVariable Long id, @RequestBody User user) {
        User u = users.get(id);
        u.setName(user.getName());
        u.setAge(user.getAge());
        users.put(id, u);
        return "success";
    }

    /** 
     * 处理"/users/{id}"的DELETE请求，用来删除User
     *  
     *  @param id
     *  @return 
     */ 
    @ApiOperation("删除用户")
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        users.remove(id);
        return "success";
    }
    
}
