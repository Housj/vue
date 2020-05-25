package com.example.controller;

import com.example.entity.User;

import com.example.repository.UserRepository;
import com.example.util.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

/**
 * @author sergei
 * @create 2020-05-10
 */
@RestController
public class UserController {

    @Resource
    UserRepository userRepository;

    @GetMapping("/users")
    public Result<User> findAll(){
        return new Result<User>().setDatas(userRepository.findAll()).setCode(200);
    }

    @GetMapping("/test")
    public String test(){
        return  "1";
    }
}
