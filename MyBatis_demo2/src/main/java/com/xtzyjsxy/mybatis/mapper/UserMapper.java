package com.xtzyjsxy.mybatis.mapper;

import com.xtzyjsxy.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

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
    int insertUser(User user);

    User getUserById(int id);

    List<User> getAllUser();

    User checkLogin(String username,String password);

    User checkLoginByMap(Map<String,Object> map);

    User checkLoginByParam(@Param("username") String username, @Param("password")String password);

    Map<String,Object> getUserByIdToMap(int id);
}
