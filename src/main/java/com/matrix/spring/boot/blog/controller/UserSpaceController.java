package com.matrix.spring.boot.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

/**
 * 用户个人空间 控制器
 *
 * @Description
 * @Author Matrix [xhyrzldf@foxmail.com]
 * @Date 2017/9/27 23:52
 */
@Controller
@RequestMapping("/u")
public class UserSpaceController {

    @GetMapping("/{username}")
    public String userSpace(@PathVariable("username") String username){
        System.out.println("username: " + username);
        return "/userspace/u";
    }

    public String listBlogByOrder(@PathVariable("username") String username,
                                  @RequestParam(value = "order",required = false,defaultValue = "new") String order,
                                  @RequestParam(value = "category",required = false) Long category,
                                  @RequestParam(value = "keyword",required = false)String keyword) {

        if (category != null) {

            System.out.println("category: " + category);
            System.out.println("selflink: " + "redirect:/u/" + username + "/blogs?category=" + category);

            return "/userspace/u";
        } else if (keyword != null && keyword.isEmpty() == false) {
            System.out.println("keyword: " + keyword);
            System.out.println("");
            System.out.println("selflink: " + "redirect:/u/" + username + "/blogs?keyword=" + keyword);

        }

        System.out.println("order:" + order);
        System.out.println("selflink: " + "redirect:/u/" + username + "/blogs?order=" + order);
        return "/userspace/u";
    }


    /**
     * 查询用户博客
     * @param id
     * @return
     */
    @GetMapping("/{username}/blogs/{id}")
    public String listBlogsByOrder(@PathVariable("id") Long id) {

        System.out.println("blog Id: " + id );
        return "/userspace/blog";
    }


    /**
     * 编辑用户博客
     * @return
     */
    @GetMapping("/{username}/blogs/edit")
    public String editBlog(){

        return "/userspace/blogedit";
    }


}
