package com.matrix.spring.boot.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 主页控制器
 *
 * @Description
 * @Author Matrix [xhyrzldf@foxmail.com]
 * @Date 2017/9/27 23:52
 */
@Controller
public class MainController {

    /**
     * 跳转到首页
     * @return
     */
    @GetMapping("/")
    public String root(){
        return "redirect:/index";
    }

    /**
     * 跳转到首页
     * @return
     */
    @GetMapping("/index")
    public String index(){
        return "index";
    }

    /**
     * 跳转到登录
     * @return
     */
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    /**
     * 跳转到登录页面,并且携带错误信息
     * @param model
     * @return
     */
    @GetMapping("/login-error")
    public String loginError(Model model){
        model.addAttribute("loginError",true);
        model.addAttribute("errorMsg","登录失败,用户名或密码错误!");
        return "login";
    }

}
