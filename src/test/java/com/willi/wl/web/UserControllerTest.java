package com.willi.wl.web;

import com.willi.wl.service.UserService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @Author: William
 * @Description:
 * @Date: 2018/9/23 11:23
 **/
public class UserControllerTest {

    @SuppressWarnings("all")
    @Autowired
    private UserService userService;

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
        System.out.println("---------------------------getUserByNameAndPass--------------------------");
        System.out.println(userService.getUserByNameAndPass("william", "19961127"));
    }

    @Test
    public void getUserList() {
    }

    @Test
    public void getUserByEmail() {
    }

    @Test
    public void add() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void deleteByName() {
    }

    @Test
    public void update() {
    }

    @Test
    public void updateByName() {
    }
}