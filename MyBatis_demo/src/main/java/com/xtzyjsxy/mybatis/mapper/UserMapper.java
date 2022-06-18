package com.xtzyjsxy.mybatis.mapper;

import com.xtzyjsxy.mybatis.pojo.User;

import java.util.List;

/**
 * MyBatis面向接口变成的两个一致
 * 1、映射文件的namespace要和mapper接口的全类名保持一致
 * 2、映射文件中SQL语句的id要和mapper接口中的方法名一致
 */
public interface UserMapper {
    /**
     * 添加用户信息
     * @return 返回影响的条数
     */
    int insertUser();

    User getUserById(int id);

    List<User> getAllUser();
}
