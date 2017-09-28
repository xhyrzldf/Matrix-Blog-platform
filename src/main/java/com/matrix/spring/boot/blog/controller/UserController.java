package com.matrix.spring.boot.blog.controller;

import com.matrix.spring.boot.blog.domain.User;
import com.matrix.spring.boot.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * 用户 控制器
 * @Description
 * @Author Matrix[xhyrzldf@foxmail.com]
 * @Date 2017/9/13 0:46
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    /**
     * 显示所有用户信息
     *
     * @param model model
     * @return model and view
     */
    @GetMapping
    public ModelAndView list(Model model) {
        model.addAttribute("userList", userRepository.findAll());
        model.addAttribute("title", "用户管理");
        return new ModelAndView("users/list", "userModel", model);
    }

    /**
     * 根据id获得用户信息
     *
     * @param model model
     * @return model and view
     */
    @GetMapping("/{id}")
    public ModelAndView view(@PathVariable("id") Long id, Model model) {
        User user = userRepository.findOne(id);
        model.addAttribute("user", user);
        model.addAttribute("title", "查看用户");
        return new ModelAndView("users/view", "userModel", model);
    }


    /**
     * form表单创建一个表单,将一个新的user对象与页面里绑定,这样可以统一提交到saveUpdate方法里
     *
     * @param model
     * @return
     */
    @GetMapping(value = "/form")
    public ModelAndView createForm(Model model) {
        model.addAttribute("user", new User(null,null,null));
        model.addAttribute("title", "创建用户");
        return new ModelAndView("users/form", "userModel", model);
    }


    /**
     * 添加或者更新用户信息
     * @param user
     * @return
     */
    @PostMapping
    public ModelAndView saveOrUpdateUser(User user) {
        userRepository.save(user);
        return new ModelAndView("redirect:/users");
    }

    /**
     * 根据id删除用户
     * @param id
     * @return
     */
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {
        userRepository.delete(id);
        return new ModelAndView("redirect:/users");
    }

    /**
     * 根据id修改用户
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/modify/{id}")
    public ModelAndView modify(@PathVariable("id") Long id, Model model) {
        User user = userRepository.findOne(id);
        model.addAttribute("user", user);
        model.addAttribute("title", "修改用户");
        return new ModelAndView("users/form", "userModel", model);
    }


    @RequestMapping(value = "/hello")
    public String hello() {
        return "Hello World!";
    }
}
