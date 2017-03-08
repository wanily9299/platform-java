package com.zhouwei.platform.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by zhouwei on 2017/3/5.
 */
@Component
public class AppInfo {

    @Value("${app.version}")
    private String version;

    @Value("${app.name}")
    private String name;

    @Value("${jdbc.username:}")
    private String jdbcName;

    @Override
    public String toString() {
        return "AppInfo{" +
                "version='" + version + '\'' +
                ", name='" + name + '\'' +
                ", jdbcName='" + jdbcName + '\'' +
                '}';
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJdbcName() {
        return jdbcName;
    }

    public void setJdbcName(String jdbcName) {
        this.jdbcName = jdbcName;
    }
}
