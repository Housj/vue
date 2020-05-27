package com.example.controller;

import com.example.entity.User;

import com.example.repository.UserRepository;
import com.example.util.Result;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/user/{id}")
    public Result<User> getUserById(@PathVariable Long id){
        return new Result<User>().setData(userRepository.findUserById(id)).setCode(200);
    }

    @GetMapping("/users")
    public Result<User> findAll(){
        return new Result<User>().setDatas(userRepository.findAll()).setCode(200);
    }

    @GetMapping("/usersPage")
    public Result<User> findAllByPage(@RequestBody @RequestParam(name = "pageNum", defaultValue = "0") int pageNum,@RequestParam(name = "pageSize",defaultValue = "5") int pageSize){
        Page<User> pages = userRepository.findAll(PageRequest.of(pageNum,pageSize));
        return new Result<User>().setDatas(pages.getContent()).setPageNum(pages.getTotalPages()).setCount((int) pages.getTotalElements()).setCode(200);
    }

    @DeleteMapping("/user/{id}")
    public Result<String> deleteUser(@PathVariable Long id){
        userRepository.deleteById(id);
        return new Result<String>().setCode(200);
    }

    @PutMapping("/user/disable/{id}")
    public Result<String> disableUser(@PathVariable Long id){
        userRepository.disableUser(id);
        return new Result<String>().setCode(200);
    }

    @PutMapping("/user/enable/{id}")
    public Result<String> enableUser(@PathVariable Long id){
        userRepository.enableUser(id);
        return new Result<String>().setCode(200);
    }

    @PostMapping("/user")
    public Result<String> updateUser(@RequestBody User user){
        userRepository.save(user);
        return new Result<String>().setCode(200);
    }

    @GetMapping("/test")
    public String test(){
        return  "1";
    }
}
