package com.webdemo2.webdemo2.config;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(MaxUploadSizeExceededException.class)   
    // public ModelAndView uploadException(MaxUploadSizeExceededException e) throws IOException 
    public void uploadException(MaxUploadSizeExceededException e, HttpServletResponse resp) throws IOException 
    {
        // 全局异常处理，返回错误消息字符串
        resp.setContentType("text/html;charset=utf-8");     
        PrintWriter out = resp.getWriter();
        out.write("上传文件大小超出限制！");
        out.flush();
        out.close();
        
        // 下面这个没用，不知道是不是没有设置关于 /error 的路由的问题   
        // ModelAndView mv = new ModelAndView();
        // mv.addObject("msg", "上传文件大小超出限制！");
        // mv.setViewName("error");
        // return mv;
    }
}
