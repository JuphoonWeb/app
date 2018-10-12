package com.juphoon.app.config;


import com.juphoon.app.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class LoginInterceptorConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(loginInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/user_login", "/").excludePathPatterns("/getApps")
                .excludePathPatterns("/{suffix}/{versionCode}/mainflist");

      super.addInterceptors(registry);
    }

    @Bean
    public LoginInterceptor loginInterceptor() {
        return new LoginInterceptor();
    }



}
