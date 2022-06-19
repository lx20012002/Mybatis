package com.xtzyjsxy.mybatis;

import com.xtzyjsxy.mybatis.mapper.EmpMapper;
import com.xtzyjsxy.mybatis.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class testMyBatisDemo3 {
    @Test
    public void testGetAllEmp() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sessionFactory.openSession();
        EmpMapper emp = sqlSession.getMapper(EmpMapper.class);
        List<Emp> empList = emp.getAllEmp();
        empList.forEach(e-> System.out.println(e));
    }

    @Test
    public void testGetEmpAndDept() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sessionFactory.openSession();
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = empMapper.getEmpAndDept(2);
        System.out.println(emp);
    }
    @Test
    public void testGetEmpAndDeptByStep() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sessionFactory.openSession();
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = empMapper.getEmpAndDeptByStepOne(3);
        System.out.println(emp);
    }

}
