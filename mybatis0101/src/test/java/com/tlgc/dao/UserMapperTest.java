package com.tlgc.dao;

import com.sun.javafx.collections.MappingChange;
import com.tlgc.pojo.User;
import com.tlgc.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest {

    @Test
    public void test() {
        //1 获得sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //2 执行SQL
        //方式一
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserList();
        for (User user : userList) {
            System.out.println(user);
        }

        //方式二
//        List<User> userList = sqlSession.selectList("com.tlgc.dao.UserDao.getUserList");
//        for (User user : userList) {
//            System.out.println(user);
//        }
        //关闭SqlSession

        sqlSession.close();
    }


    @Test
    public void testGetByid() {
        //1 获得sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //2 执行SQL
        //方式一
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User addUser = mapper.getUserById(1);
        System.out.println(addUser.toString());
        //方式二
//        List<User> userList = sqlSession.selectList("com.tlgc.dao.UserDao.getUserList");
//        for (User user : userList) {
//            System.out.println(user);
//        }
        //关闭SqlSession

        sqlSession.close();
    }


    //增删改需要提交事务
    @Test
    public void testAdd1() {
        //1 获得sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //2 执行SQL
        //方式一
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(4, "gssad", "179");
        int res = mapper.addUser(user);
        if (res > 0) {
            System.out.println("插入成功");
        }
        //提交事务
        sqlSession.commit();
        //关闭SqlSession
        sqlSession.close();
    }

    //增删改需要提交事务
    @Test
    public void testAdd2() {
        //1 获得sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //2 执行SQL
        //方式一
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> myMap = new HashMap<String, Object>();
        myMap.put("userId", 6);
        myMap.put("userName", "hs");
        myMap.put("password", "336");
        int res = mapper.addUser2(myMap);
        if (res > 0) {
            System.out.println("插入成功");
        }
        //提交事务
        sqlSession.commit();
        //关闭SqlSession
        sqlSession.close();
    }

    @Test
    public void testUpdate() {
        //1 获得sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //2 执行SQL
        //方式一
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int res = mapper.updateUser(new User(2, "huangshan", "shanhuang"));
        if (res > 0) {
            System.out.println("修改成功");
        }
        //提交事务
        sqlSession.commit();
        //关闭SqlSession
        sqlSession.close();
    }

    @Test
    public void testDelete() {
        //1 获得sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //2 执行SQL
        //方式一
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int res = mapper.deleteUser(3);
        if (res > 0) {
            System.out.println("删除成功");
        } else {
            System.out.println("未删除成功");
        }
        //提交事务
        sqlSession.commit();
        //关闭SqlSession
        sqlSession.close();
    }

    @Test
    public void testListLike() {
        //1 获得sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //2 执行SQL
        //方式一
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> hs = mapper.getUserLike("hs");
        for (User user : hs) {
            System.out.println(user);
        }
        //关闭SqlSession
        sqlSession.close();
    }


}
