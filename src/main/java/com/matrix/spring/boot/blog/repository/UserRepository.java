package com.matrix.spring.boot.blog.repository;

import com.matrix.spring.boot.blog.domain.User;

import java.util.List;

/**
 * @Description User Repository Interface
 * @Author 李迪凡[xhyrzldf@foxmail.com]
 * @Date 2017/9/13 13:39
 */
public interface UserRepository {

    User saveOrUpdateUser(User user);

    void deleteUser(Long id);

    User getUserById(Long id);

    List<User> listUser();
}
