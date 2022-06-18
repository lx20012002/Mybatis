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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        //List<User> users = mapper.getAllUser();
        //users.forEach(user -> System.out.println(user.getUsername()));
        User user = mapper.getUserById(1);
        System.out.println(user.getUsername());

    }

    @Test
    public void checkLogin() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.checkLogin("zhangsan","123456");
        System.out.println(user !=null?user.getUsername():"账户密码不正确");
    }

    @Test
    public void checkLoginByMap() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("username","zhangsan");
        map.put("password","123456");
        User user = userMapper.checkLoginByMap(map);
        System.out.println(user !=null?user.getUsername():"账户密码不正确");
    }

    @Test
    public void insert() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(null,"lisi","123456",22,"男","789@qq.com");
        int update = userMapper.insertUser(user);
        sqlSession.commit();
        System.out.println(update);
    }
    @Test
    public void testCheckLoginByParam() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.checkLoginByParam("zhangsan","123456");
        System.out.println(user !=null?user.getUsername():"账户密码不正确");
    }

    @Test
    public void testGetUserByIdToMap() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Map<String,Object> map =  userMapper.getUserByIdToMap(9);
        System.out.println(map);
    }
}
