package com.willi.wl.mapper;

import com.willi.wl.bean.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @Author: William
 * @Description:
 * @Date: 2018/8/15 16:10
 **/
public interface UserMapper {

    @Select("SELECT * FROM wl_user WHERE id = #{id}")
    User getUserById(Integer id);

    @Select("SELECT * FROM wl_user WHERE username=#{name}")
    User getUserByName(String name);

    @Select("SELECT * FROM wl_user WHERE username=#{name} AND password=#{password}")
    User getUserByNameAndPass(@Param("name") String name, @Param("password") String password);

    @Select("SELECT * FROM wl_user")
    List<User> getUserList();

    @Select("SELECT *  FROM wl_user WHERE email=#{email}")
    User getUserByEmail(String email);

    @Insert("INSERT into wl_user(user_id, username, password, email, createTime) value(#{user_id}, #{username}, #{password}, #{email}, #{createTime})")
    int add(User user);

    @Update("UPDATE wl_user SET username = #{user.username}, password = #{user.password}, email = #{user.email}, age = #{user.age}, sex = #{user.sex}, height = #{user.height}, weight = #{user.weight}, phone = #{user.phone} WHERE id = #{id}")
    int update(@Param("id") Integer id, @Param("user") User user);

    @Update("UPDATE wl_user SET username = #{user.username}, password = #{user.password}, email = #{user.email}, age = #{user.age}, sex = #{user.sex}, height = #{user.height}, weight = #{user.weight}, phone = #{user.phone} WHERE username = #{name}")
    int updateByName(@Param("name") String name, @Param("user") User user);

    @Delete("DELETE FROM wl_user where id = #{id}")
    int delete(Integer id);

    @Delete(("DELETE FROM wl_user WHERE username = #{name}"))
    int deleteByName(String name);
}
