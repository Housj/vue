package com.example.repository;

import com.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author sergei
 * @create 2020-05-10
 */

public interface UserRepository extends JpaRepository<User, Long> {

}
