package com.example.controller;

import com.example.entity.User;
import com.example.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringbootControllerApplicationTests {

    @Resource
    UserRepository userRepository;

    @Test
    void contextLoads() {

        List<User> lists = userRepository.findAll();
        lists.forEach(user -> {
            System.out.println(user.sname);
        });
    }

}
