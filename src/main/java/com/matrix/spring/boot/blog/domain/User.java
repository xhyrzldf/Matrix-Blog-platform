package com.matrix.spring.boot.blog.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @Description User实体
 * @Author 李迪凡[xhyrzldf@foxmail.com]
 * @Date 2017/9/13 13:35
 */
@Entity//jpa规范 实体类上必须要加@entity注解
public class User {

    @Id//主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自增长策略
    private Long id;

    private String name;

    private String email;

    protected User() {//无直接构造函数,防止直接构造,JPA规范
    }

    public User(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public User setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
