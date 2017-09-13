package com.matrix.spring.boot.blog.repository;

import com.matrix.spring.boot.blog.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @Description
 * @Author 李迪凡[xhyrzldf@foxmail.com]
 * @Date 2017/9/13 13:45
 */
@Repository
public class UserRepositoryImpl implements UserRepository {

    private static AtomicLong counter = new AtomicLong();

    private final ConcurrentMap<Long, User> userMap = new ConcurrentHashMap<>();


    @Override
    public User saveOrUpdateUser(User user) {
        Long id = user.getId();
        if (id == null) { //new
            id = counter.incrementAndGet();
            user.setId(id);
        }
        this.userMap.put(id,user);
        return user;
    }

    @Override
    public void deleteUser(Long id) {
        this.userMap.remove(id);

    }

    @Override
    public User getUserById(Long id) {
        return this.userMap.get(id);

    }

    @Override
    public List<User> listUser() {
        return new ArrayList<>(this.userMap.values());
    }
}
