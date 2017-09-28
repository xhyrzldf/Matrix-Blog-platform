package com.matrix.spring.boot.blog.repository;

import com.matrix.spring.boot.blog.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @Description User Repository Interface
 * @Author Matrix[xhyrzldf@foxmail.com]
 * @Date 2017/9/13 13:39
 */
public interface UserRepository extends CrudRepository<User, Long> {

}
