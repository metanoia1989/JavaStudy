package com.webdemo2.webdemo2.exception;

import java.util.Map;

import org.springframework.boot.web.reactive.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.function.ServerRequest;

// @Component
// public class MyErrorAttribute extends DefaultErrorAttributes {
//     @Override    
//     // public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
// 	public Map<String, Object> getErrorAttributes(ServerRequest request, boolean includeStackTrace) {
//         Map<String, Object> errorAttributes = super.getErrorAttributes(request, includeStackTrace); 
//         errorAttributes.put("custommsg", "出错啦！");
//         errorAttributes.remove("error");
//         return errorAttributes;
//     }
// }

