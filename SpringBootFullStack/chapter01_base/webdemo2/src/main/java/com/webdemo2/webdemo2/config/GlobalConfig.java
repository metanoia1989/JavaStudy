package com.webdemo2.webdemo2.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice // 全局数据处理组件，可以配置全局数据
public class GlobalConfig {
    @ModelAttribute(value = "info")  // 存入全局Model中，键为info
    public Map<String, String> userInfo() {
        HashMap<String, String> map = new HashMap<>();
        map.put("username", "罗贯中");
        map.put("gender", "男");
        return map;
    }
    
    @InitBinder("b")  // 处理 @ModelAttribute("b") 对应的参数
    public void init(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("b."); 
    }

    @InitBinder("a") // 处理 @ModelAttribute("a") 对应的参数
    public void init2(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("a."); 
    }
}
