package com.willi.wl.mapper;

import com.willi.wl.bean.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Author: William
 * @Description: UserMapper 测试
 * @Date: 2018/8/15 17:59
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @SuppressWarnings("all")
    @Autowired
    private UserMapper userMapper;

    @Test
    public void getUserById() {
        System.out.println("----------------------------getUserById Test-----------------------------");
        System.out.println(userMapper.getUserById(2));

    }

    @Test
    public void getUserByName() {
        System.out.println("----------------------------getUserByName Test-----------------------------");
        System.out.println(userMapper.getUserByName("yaoguo"));
    }

    @Test
    public void getUserByNameAndPass() {
        System.out.println("----------------------------getUserByNameAndPass Test-----------------------------");
        System.out.println(userMapper.getUserByNameAndPass("william", "19961127"));
    }

    @Test
    public void getUserList() {
    }

    @Test
    public void getUserByEmail() {
        System.out.println("----------------------------getUserByEmail Test-----------------------------");
        System.out.println(userMapper.getUserByEmail("2601865991@qq.com"));
    }

    @Test
    public void add() {
    }

    @Test
    public void update() {
    }

    @Test
    public void updateByName() {
        System.out.println("----------------------------getUserByEmail Test-----------------------------");

    }

    @Test
    public void delete() {
    }

    @Test
    public void deleteByName() {
        System.out.println("----------------------------getUserByEmail Test-----------------------------");
        System.out.println(userMapper.deleteByName("yaoguo"));
    }
}