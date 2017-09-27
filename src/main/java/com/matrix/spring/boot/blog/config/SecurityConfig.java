package com.matrix.spring.boot.blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 安全配置类
 *
 * @Description
 * @Author Matrix [xhyrzldf@foxmail.com]
 * @Date 2017/9/27 23:38
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    /**
     * 自定义配置
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/css/**","/js/**","/fonts/**","/index").permitAll() //可以直接访问
                .antMatchers("/users/**").hasRole("ADMIN") //需要相应角色才能访问
                .and()
                .formLogin()  //基于Form 表单登录验证
                .loginPage("/login").failureUrl("/login-error"); //自定义登录页面
    }

    /**
     * 认证信息管理
     * @param auth
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication() //存储在内存中
                .withUser("matrix").password("123456").roles("ADMIN");
    }

}
