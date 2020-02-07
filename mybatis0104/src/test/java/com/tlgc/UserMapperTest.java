package com.tlgc;

import com.tlgc.dao.UserMapper;
import com.tlgc.pojo.User;
import com.tlgc.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

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
    }
    
}
