package com.example.controller;

import com.example.entity.User;
import com.example.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;
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
            System.out.println(user.name);
        });
    }

    @Test
    void add(){
        User u = new User().setName("test2").setPassword("test22").setStatus(0).setCreateDate(new Date());
        userRepository.save(u);
    }

    @Test
    void page(){
        Pageable pageable = PageRequest.of(1,2);
        Page<User> userList = userRepository.findAll(pageable);

        userList.forEach(user -> System.out.println(user.getId()));
    }
}
