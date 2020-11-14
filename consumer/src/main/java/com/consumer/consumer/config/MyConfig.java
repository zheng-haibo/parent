package com.consumer.consumer.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationEntryPointFailureHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.csrf.CsrfAuthenticationStrategy;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@EnableWebSecurity
public class MyConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) throws Exception {

        super.configure(web);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //开启csrf防御
        http
                //开启csrf防御
                .csrf().csrfTokenRepository(new HttpSessionCsrfTokenRepository())
                .and()
                //有哪些地址需要登录
                .authorizeRequests()
                //所有请求都要进行验证
                .anyRequest().authenticated()
                .and()
                //自定义登录页面
                .formLogin().loginPage("/login.html")
                //登录的请求不需要进行验证
                .loginProcessingUrl("/login").permitAll()
                //登录失败页面
                .failureUrl("/login.html?error")
                //登录成功跳转页面，登录成功后固定跳转
                .defaultSuccessUrl("/hello", true).permitAll()
                .usernameParameter("xx")
                .passwordParameter("oo")
                .failureHandler(new AuthenticationFailureHandler() {
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest httpServletRequest,
                                                        HttpServletResponse httpServletResponse,
                                                        AuthenticationException e) throws IOException, ServletException {

                        e.printStackTrace();

                        httpServletRequest.getRequestDispatcher(
                                httpServletRequest.getRequestURL().toString())
                                .forward(httpServletRequest, httpServletResponse);

                    }
                })
        ;
    }
}
