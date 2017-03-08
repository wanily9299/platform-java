//package com.zhouwei.platform.config;
//
//import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.core.io.Resource;
//
///**
// * Created by zhouwei on 2017/3/8.
// */
//@Configuration
//public class SpringConfig {
//    @Bean
//    public PropertyPlaceholderConfigurer propertyPlaceholderConfigurer(){
//        PropertyPlaceholderConfigurer propertyPlaceholderConfigurer = new PropertyPlaceholderConfigurer();
//        ClassPathResource resource = new ClassPathResource("/config/application.properties");
//        propertyPlaceholderConfigurer.setLocations(new Resource[]{resource});
//        return propertyPlaceholderConfigurer;
//    }
//}
