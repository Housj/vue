package com.example.repository;

import com.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author sergei
 * @create 2020-05-10
 */

public interface UserRepository extends JpaRepository<User, Long> {

    @Transactional
    @Modifying
    @Query(value = "update user set status = 1 where id = :id",nativeQuery = true)
    int disableUser(Long id);

    @Transactional
    @Modifying
    @Query(value = "update user set status = 0 where id = :id",nativeQuery = true)
    int enableUser(Long id);

    User findUserById(Long id);
}
