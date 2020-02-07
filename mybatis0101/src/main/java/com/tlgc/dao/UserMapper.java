package com.tlgc.dao;

import com.tlgc.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    List<User> getUserList();

    //根据id查询用户
    User getUserById(int id);

    //insert一个用户
    int addUser(User user);

    //万能Map
    int addUser2(Map<String, Object> map);

    //修改用户
    int updateUser(User user);

    //删除一个用户
    int deleteUser(int id);

    //模糊查询
    List<User> getUserLike(String value);

}
