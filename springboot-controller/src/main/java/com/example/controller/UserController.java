package com.example.controller;

import com.example.entity.User;
import com.example.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author sergei
 * @create 2020-05-10
 */
@RestController
public class UserController {

    @Resource
    UserRepository userRepository;

    @GetMapping("/users")
    public List<User> findAll(){
        return  userRepository.findAll();
    }

    @GetMapping("/test")
    public String test(){
        return  "1";
    }
}
