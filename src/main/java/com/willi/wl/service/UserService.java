package com.willi.wl.service;

import com.willi.wl.bean.User;

import java.util.List;

/**
 * @Author: William
 * @Description:
 * @Date: 2018/8/15 14:31
 **/
public interface UserService {

    User getUserById(Integer id);

    User getUserByName(String username);

    User getUserByNameAndPass(String name, String password);

    public List<User> getUserList();

    User getUserByEmail(String email);

    public int add(User user);

    public int update(Integer id, User user);

    public int updateByName(String name, User user);

    public int delete(Integer id);

    public int deleteByName(String name);

}
