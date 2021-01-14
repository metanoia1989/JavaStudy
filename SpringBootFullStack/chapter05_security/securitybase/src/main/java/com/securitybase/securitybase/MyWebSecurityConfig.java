package com.securitybase.securitybase;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
public class MyWebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    } 
    
    // 添加基于内存的用户和角色
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication() 
            .withUser("root").password("123456").roles("ADMIN", "DBA")
            .and()
            .withUser("admin").password("123456").roles("ADMIN", "USER")
            .and()
            .withUser("adam").password("123456").roles("USER");
    }

    // 过滤不需要验证的路径
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/vercode"); 
    } 
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests() 
            .antMatchers("/admin/**")
            .hasRole("ADMIN")
            .antMatchers("/user/**")
            .access("hasAnyRole('ADMIN', 'USER')")
            .antMatchers("/db/**")
            .access("hasRole('ADMIN') and hasRole('DBA')")
            .anyRequest()
            .authenticated()
            .and()
            .formLogin()
            .loginPage("/login_page")
            .loginProcessingUrl("/login")
            .usernameParameter("name")
            .passwordParameter("passwd")
            .successHandler(new AuthenticationSuccessHandler(){
                @Override
                public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse resp, 
                    Authentication auth) throws IOException {
                    Object principal = auth.getPrincipal();
                    resp.setContentType("application/json;charset=utf-8");
                    PrintWriter out = resp.getWriter();
                    resp.setStatus(200);
                    Map<String, Object> map = new HashMap<>();
                    map.put("status", 200);
                    map.put("msg", principal);
                    ObjectMapper om = new ObjectMapper();
                    out.write(om.writeValueAsString(map));
                    out.flush();
                    out.close();
                }   
            })
            .failureHandler(new AuthenticationFailureHandler(){
                @Override
                public void onAuthenticationFailure(HttpServletRequest req, HttpServletResponse resp,
                    AuthenticationException e) throws IOException  {
                        resp.setContentType("application/json;charset=utf-8");
                        PrintWriter out = resp.getWriter();
                        resp.setStatus(401);
                        Map<String, Object> map = new HashMap<>();
                        map.put("status", 401);
                        if (e instanceof LockedException) {
                            map.put("msg", "账户被锁定，登录失败！");
                        } else if ( e instanceof BadCredentialsException) {
                            map.put("msg", "账户名或密码输入错误，登录失败！");
                        } else if ( e instanceof DisabledException) {
                            map.put("msg", "账户被禁用，登录失败！");
                        } else if ( e instanceof AccountExpiredException) {
                            map.put("msg", "账户已过期，登录失败！");
                        } else if ( e instanceof CredentialsExpiredException) {
                            map.put("msg", "密码已过期，登录失败！");
                        } else {
                            map.put("msg", "登录失败！");
                        }
                        ObjectMapper om = new ObjectMapper();
                        out.write(om.writeValueAsString(map));
                        out.flush();
                        out.close();
                } 
            })
            .permitAll()
            .and()
            .csrf()
            .disable();
    }
}
