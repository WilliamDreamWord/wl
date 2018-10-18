package com.willi.wl.service.impl;

import com.willi.wl.bean.User;
import com.willi.wl.mapper.UserMapper;
import com.willi.wl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: William
 * @Description:
 * @Date: 2018/8/15 14:33
 **/
@Service
public class UserServiceImpl implements UserService {

    @SuppressWarnings("all")

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(Integer id) { return userMapper.getUserById(id); }

    @Override
    public User getUserByName(String name) { return userMapper.getUserByName(name); }

    @Override
    public User getUserByNameAndPass(String name, String password) { return userMapper.getUserByNameAndPass(name, password); }

    @Override
    public List<User> getUserList() {
        return userMapper.getUserList();
    }

    @Override
    public User getUserByEmail(String email) {
        return userMapper.getUserByEmail(email);
    }

    @Override
    public int add(User user) {
        return userMapper.add(user);
    }

    @Override
    public int update(Integer id, User user) {
        return userMapper.update(id, user);
    }

    @Override
    public int updateByName(String name, User user) {
        return userMapper.updateByName(name, user);
    }

    @Override
    public int delete(Integer id) {
        return userMapper.delete(id);
    }

    @Override
    public int deleteByName(String name) {
        return userMapper.deleteByName(name);
    }
}
