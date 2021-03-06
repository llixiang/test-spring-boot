package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author LiXiang
 * @date 2020/6/5 17:18
 */
@Service
public class UserServiceImpl {
    @Resource
    private UserMapper userMapper;


    public List<User> selectUser() {
        List<User> users = userMapper.selectList(null);
        return users;
    }

    public User selectById(Long id) {
        User user = userMapper.selectById(id);
        return user;
    }
}
