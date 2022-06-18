package com.xtzyjsxy.mybatis.test;

import com.xtzyjsxy.mybatis.mapper.UserMapper;
import com.xtzyjsxy.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {

    @Test
    public void testMyBatis() throws IOException {
        //加载核心配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //获取SqlSessionFactoryBuilder
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //获取SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        //获取SqlSession:代表Java程序和数据库之间的会话
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取mapper接口对象，底层其实帮我们创建了一个UserMapper接口的实现类（UserMapperImpl）对象，本质是动态代理
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //测试功能
        //int result = mapper.insertUser();
        //提交事务
        List<User> users = mapper.getAllUser();
        users.forEach(user -> System.out.println(user.getUsername()));
    }
}
