package com.example.service;

import com.example.entity.User;
import com.example.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author sergei
 * @create 2020-05-25
 */
@Service
public class UserService {

    @Resource
    UserRepository userRepository;

    Page<User> findAllUser(Pageable pageable){
        return userRepository.findAll(pageable);
    }

}
