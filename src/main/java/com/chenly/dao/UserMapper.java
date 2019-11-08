package com.chenly.dao;

import com.chenly.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wangchuan
 * @date 2019/5/29.
 */

public interface UserMapper {
    Integer insertOne(User user);
    void updateUser(User user);

//    User selectByNameAndPwd(String username, String password);
    List<User> selectAll();
    User selectById(@Param("id") Integer id);
    User selectByNameAndPwd(@Param("user") User user);
    void deleteUser(@Param("id") Integer id);
}
