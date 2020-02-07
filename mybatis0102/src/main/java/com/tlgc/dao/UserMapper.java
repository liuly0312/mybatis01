package com.tlgc.dao;

import com.tlgc.pojo.User;
import org.apache.ibatis.type.Alias;

import java.util.List;
import java.util.Map;


public interface UserMapper {

    List<User> getUserList();

    //根据id查询用户
    User getUserById(int id);

    //insert一个用户
    int addUser(User user);


    //修改用户
    int updateUser(User user);

    //删除一个用户
    int deleteUser(int id);

}
