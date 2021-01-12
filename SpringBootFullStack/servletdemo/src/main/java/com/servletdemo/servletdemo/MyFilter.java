package com.servletdemo.servletdemo;


import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*")
public class MyFilter implements Filter {
    @Override 
    public void init(FilterConfig filterConfig) {
        System.out.println("MyFilter>>>init");
    }

    @Override 
    public void doFilter(javax.servlet.ServletRequest req, javax.servlet.ServletResponse resp, javax.servlet.FilterChain chain) 
        throws java.io.IOException, javax.servlet.ServletException {
        System.out.println("MyFilter>>>doFilter");
        chain.doFilter(req, resp);
    }

    @Override 
    public void destroy() {
        System.out.println("MyFilter>>>destory");
    }
}
