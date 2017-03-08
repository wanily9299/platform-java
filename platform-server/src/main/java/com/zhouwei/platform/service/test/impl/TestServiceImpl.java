package com.zhouwei.platform.service.test.impl;

import com.zhouwei.platform.bean.test.Test;
import com.zhouwei.platform.mapper.test.TestMapper;
import com.zhouwei.platform.service.test.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhouwei on 2017/3/6.
 */
@Service
public class TestServiceImpl implements TestService {

    private static Logger log = LoggerFactory.getLogger(TestServiceImpl.class);

    @Autowired
    TestMapper testMapper;

    public Test selectById(String id) {

        log.info("info:"+id);
        log.debug("debug:"+id);
        log.warn("warn:"+id);
        log.error("error:"+id);


        Test test = testMapper.selectById(id);
        return test;
    }
}
