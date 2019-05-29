package com.chenly.dao;

import com.chenly.model.User;

import java.util.List;

/**
 * @author wangchuan
 * @date 2019/5/29.
 */
public interface UserMapper {
    User selectByNameAndPwd(String username, String password);
    List<User> selectAll();
    User selectById(Integer id);
    void insertOne(User user);
    void updateOne(User user);
    void delete(Integer id);
}
