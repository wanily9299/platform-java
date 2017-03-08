package com.zhouwei.platform.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Created by zhouwei on 2017/3/8.
 */
@Configuration
@ComponentScan(basePackages = "com.zhouwei.platform")
@EnableWebMvc
public class WebConfig {
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        //前缀
        viewResolver.setPrefix("/html/");
        //后缀
        viewResolver.setSuffix(".html");
        viewResolver.setViewClass(JstlView.class);
        return viewResolver;
    }
}
