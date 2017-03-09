package com.zhouwei.platform.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhouwei.platform.bean.interceptor.MyInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhouwei on 2017/3/8.
 */
@Configuration
@ComponentScan(basePackages = "com.zhouwei.platform")
//@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurationSupport {
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        //前缀
        viewResolver.setPrefix("/html/");
        //后缀
        viewResolver.setSuffix(".html");
        viewResolver.setContentType("text/html");
        return viewResolver;
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        // 开启默认转发
        configurer.enable();
    }


    @Override
    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter();
        List<MediaType> supportedMediaTypes = new ArrayList<MediaType>();
        MediaType mediaType = new MediaType("text","html", Charset.forName("utf-8"));
        supportedMediaTypes.add(mediaType);
        stringHttpMessageConverter.setSupportedMediaTypes(supportedMediaTypes);
        converters.add(stringHttpMessageConverter);

        ObjectMapper objectMapper = Jackson2ObjectMapperBuilder.json().build();
        converters.add(new MappingJackson2HttpMessageConverter(objectMapper));
    }


    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**").addResourceLocations("/static/css/");
    }

    @Override
    protected void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("redirect:/test/html");//浏览器重定向到controller
        registry.addViewController("/index").setViewName("test");//根据viewResolver直接跳转到/html/test.html,不经过controller
    }


    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myInterceptor());
    }

    @Bean
    public MyInterceptor myInterceptor(){
        return new MyInterceptor();
    }
}
