package com.chenly.controller;

import com.alibaba.fastjson.JSON;
import com.chenly.model.User;
import com.chenly.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author wangchuan
 * @date 2019/5/30.
 */
@Controller
@RequestMapping("/user")
@Slf4j
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

    @PostMapping("/login")
    @ResponseBody
    public String selectUser(@RequestBody User user){
        log.info("用户：：：：" + JSON.toJSONString(user));
        User login = userService.login(user);
        if (StringUtils.isEmpty(login)) {
            return "登录失败";
        }
        return "登录成功";
    }

    @RequestMapping("/selectAll")
    @ResponseBody
    public List<User> selectAll(){
        return userService.selectAll();
    }

    @RequestMapping("/deleteUser")
    public void delete(Integer id){
        userService.deleteUser(id);
    }
}
