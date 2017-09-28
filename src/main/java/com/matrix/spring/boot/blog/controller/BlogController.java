package com.matrix.spring.boot.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Blog 控制器
 *
 * @Description
 * @Author Matrix [xhyrzldf@foxmail.com]
 * @Date 2017/9/27 23:52
 */
@Controller
@RequestMapping("/blogs")
public class BlogController {

    @GetMapping
    public String listBlogs(@RequestParam(value = "order", required = false, defaultValue = "new") String order
            , @RequestParam(value = "keyword", required = false, defaultValue = "") String keyword) {
        System.out.println("order: " + order + ";keyword: " + keyword);
        return "redirect:/index?order=" + order + "&keyword=" + keyword;
    }
}
