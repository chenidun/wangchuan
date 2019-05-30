package com.chenly.service;

import com.chenly.model.User;

import java.util.List;

/**
 * @author wangchuan
 * @date 2019/5/30.
 */
public interface UserService {
    Integer insertUser(User user);
    void updateUser(User user);
    User selectUser(Integer id);
    List<User> selectAll();
    void deleteUser(Integer id);
}
