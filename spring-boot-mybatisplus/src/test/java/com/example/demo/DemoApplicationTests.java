package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
class DemoApplicationTests {

    @Autowired
    private UserServiceImpl userService;

    @Test
    void userInfo(Long id) {
        User user = userService.selectById(5L);
        log.info("==>------------" + user);
    }

    @Test
    void userList() {
        List<User> users = userService.selectUser();
        users.stream().forEach(user -> {
            log.info("==>------------" + user);
        });
    }
}
