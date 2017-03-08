package com.zhouwei.platform.controller.test;

import com.zhouwei.platform.bean.test.Test;
import com.zhouwei.platform.service.test.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zhouwei on 2017/3/6.
 */
@Controller
@RequestMapping("test")
public class TestController {

    private static Logger log = LoggerFactory.getLogger(TestController.class);

    @Autowired
    TestService testService;


    @RequestMapping("/id")
    @ResponseBody
    public Test loadTest(String id){
        return testService.selectById(id);
    }

    @RequestMapping("/name")
    @ResponseBody
    public String loadTestName(String id){
        return testService.selectById(id).getName();
    }

    @RequestMapping("html")
    public String toTestHtml(){
        log.debug("in test html");
        return "test";
    }
}
