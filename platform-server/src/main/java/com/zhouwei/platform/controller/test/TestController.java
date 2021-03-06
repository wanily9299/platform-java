package com.zhouwei.platform.controller.test;

import com.zhouwei.platform.bean.test.Test;
import com.zhouwei.platform.service.test.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

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

    @RequestMapping("default")
    public String toTestDefaultHtml(){
        log.debug("toTestDefaultHtml");
        return "/html/test.html";
    }


    @RequestMapping("transaction")
    @ResponseBody
    public String transaction(String id){
        log.debug("test transaction");
        return testService.saveTestTransaction(id);
    }

    @RequestMapping("notransaction")
    @ResponseBody
    public String notransaction(String id){
        log.debug("test notransaction");
        return testService.testNoTransaction(id);
    }


    @RequestMapping("ctx")
    @ResponseBody
    public String ctx(HttpServletRequest request){
        return (String) request.getAttribute("ctx");
    }


}
