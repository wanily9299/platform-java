package com.zhouwei.platform.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * Created by zhouwei on 2017/3/8.
 */
@Configuration
//@PropertySources({
//        @PropertySource("classpath:/config/application.properties"),
//        @PropertySource("classpath:/config/jdbc.properties")
//})
public class PropertiesConfig {
        @Bean
    public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
            PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
            ClassPathResource resource = new ClassPathResource("/config/application.properties");
            propertySourcesPlaceholderConfigurer.setLocations(new Resource[]{resource});
        return propertySourcesPlaceholderConfigurer;
    }
}
