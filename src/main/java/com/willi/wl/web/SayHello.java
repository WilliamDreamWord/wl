package com.willi.wl.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.willi.wl.utils.EmailUtil;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class SayHello {

    // 应为slf4j中logger，否则为util默认的logger
    private static final org.slf4j.Logger logger =  LoggerFactory.getLogger(SayHello.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping(value = "/William")
    public List<Map<String, Object>> hello() throws JsonProcessingException {

        logger.info("druid test");

        // mysql数据库中user和authentication_string来代表用户名和密码
        List<Map<String, Object>> list = jdbcTemplate.queryForList("SELECT User,authentication_string FROM mysql.user", new Object[]{});

        return list;
    }

    @GetMapping(value = "/sendEmail")
    public String sendEmail() throws JsonProcessingException {
        boolean isSend = EmailUtil.sendEmail("Email Test", new String[]{"2601865991@qq.com"}, null, "william's love！You are my love! I love you !", null);
        if(isSend)
            logger.info("Test Send Mail Auto Successful!!");
        return "Email test:" + isSend;
    }
}
