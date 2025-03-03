package com.alfonsovidrio.springboot.app.interceptor.springboot_interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig implements WebMvcConfigurer{

    @Autowired
    @Qualifier("loadingTimeInterceptor")
    private HandlerInterceptor timeInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // registry.addInterceptor(timeInterceptor).addPathPatterns("/app/bar","/app/foo");
        // registry.addInterceptor(timeInterceptor).addPathPatterns("/app/**");
        registry.addInterceptor(timeInterceptor).excludePathPatterns("/app/baz");
    }
    
}
