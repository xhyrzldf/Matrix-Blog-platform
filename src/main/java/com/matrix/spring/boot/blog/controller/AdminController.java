package com.matrix.spring.boot.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 后台管理控制器
 *
 * @Description
 * @Author Matrix [xhyrzldf@foxmail.com]
 * @Date 2017/9/27 23:52
 */
@Controller
@RequestMapping("/admins")
public class AdminController {

    /**
     * 获得后台管理主页面
     * @param model
     * @return
     */
    @GetMapping
    public ModelAndView listUsers(Model model) {
        return new ModelAndView("admins/index", "menuList", model);
    }
}
