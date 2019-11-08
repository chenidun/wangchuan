package com.chenly.service.impl;

import com.chenly.dao.UserMapper;
import com.chenly.model.User;
import com.chenly.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wangchuan
 * @date 2019/5/30.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public Integer insertUser(User user) {
        Integer id = userMapper.insertOne(user);
        return id;
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public User selectUser(Integer id) {
        return userMapper.selectById(id);
    }

    @Override
    public User login(User user) {
        return userMapper.selectByNameAndPwd(user);
    }
    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }

    @Override
    public void deleteUser(Integer id) {
        userMapper.deleteUser(id);
    }

}
