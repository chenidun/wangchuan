package com.chenly.controller;

import com.chenly.model.User;
import com.chenly.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author wangchuan
 * @date 2019/5/30.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/insertUser")
    @ResponseBody
    public Integer insertUser(@RequestBody User user){
        Integer id = userService.insertUser(user);
        return id;
    }

    @RequestMapping("/updateUser")
    public void updateUSer(@RequestBody User user){
        userService.updateUser(user);
    }

    @RequestMapping("/selectUser")
    @ResponseBody
    public User selectUser(Integer id){
        return userService.selectUser(id);
    }

    @RequestMapping("/deleteUser")
    public void delete(Integer id){
        userService.deleteUser(id);
    }
}
