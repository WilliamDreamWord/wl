package com.willi.wl.service.impl;

import com.willi.wl.mapper.UserMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @Author: William
 * @Description:
 * @Date: 2018/9/21 20:05
 **/
public class UserServiceImplTest {

    @Autowired
    private UserMapper userMapper;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getUserById() {
    }

    @Test
    public void getUserByName() {
    }

    @Test
    public void getUserByNameAndPass() {
        System.out.println(userMapper.getUserByNameAndPass("william", "19961127"));
    }

    @Test
    public void getUserList() {
    }

    @Test
    public void add() {
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }
}