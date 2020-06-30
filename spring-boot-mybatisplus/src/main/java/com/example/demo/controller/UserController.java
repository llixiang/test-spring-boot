package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author LiXiang
 * @date 2020/6/5 17:13
 */
@RequestMapping
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/userlist")
    public List<User> selectUser() {
        return userService.selectUser();
    }
}
