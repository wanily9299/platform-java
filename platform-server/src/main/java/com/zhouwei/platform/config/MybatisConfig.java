package com.zhouwei.platform.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.zhouwei.platform.bean.test.Test;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * Created by zhouwei on 2017/3/8.
 */
@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = "com.zhouwei.platform.mapper", sqlSessionFactoryRef = "sqlSessionFactory")
public class MybatisConfig {

    @Value("${jdbc.url}")
    private String jdbcUrl;

    @Value("${jdbc.driverClassName}")
    private String driverClass;

    @Value("${jdbc.username}")
    private String user;

    @Value("${jdbc.password}")
    private String password;


    @Bean
    public Test test(ApplicationContext applicationContext){
        Object dataSource1 = applicationContext.getBean("dataSource");
        System.out.println(dataSource1.getClass().getName());
        return new Test();
    }


    @Bean(name = "dataSource",destroyMethod = "close")
    public DataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setDriverClass(driverClass);
        dataSource.setUser(user);
        dataSource.setPassword(password);
        dataSource.setAcquireRetryAttempts(3);
        //Object dataSource1 = applicationContext.getBean("dataSource");
        //System.out.println(dataSource1.getClass().getName());
        return dataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(ApplicationContext applicationContext) throws Exception {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource());
        sqlSessionFactory.setMapperLocations(applicationContext.getResources("classpath*:com/zhouwei/platform/mapper/*/*Mapper.xml"));
        return sqlSessionFactory.getObject();
    }


    @Bean(name = "transactionManager")
    public PlatformTransactionManager txManager() throws PropertyVetoException {
        return new DataSourceTransactionManager(dataSource());
    }

}
