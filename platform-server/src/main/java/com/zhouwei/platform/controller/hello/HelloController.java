package com.zhouwei.platform.controller.hello;

import com.zhouwei.platform.bean.AppInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.sql.DataSource;

/**
 * Created by zhouwei on 2017/3/3.
 */
@Controller
public class HelloController {

    @Autowired
    AppInfo appInfo;

//    @Autowired
//    DataSource dataSource;

    @RequestMapping("/hello")
    public @ResponseBody String test() {
        return "hello, world! This com from spring!";
    }

    @RequestMapping("/appinfo")
    public @ResponseBody String appinfo(){
        return appInfo.toString();
    }

//    @RequestMapping("/dbinfo")
//    public @ResponseBody String dbinfo() throws SQLException {
//        return dataSource.getConnection("root", "root123").getCatalog();
//    }

}