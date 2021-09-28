package com.example.springbootproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @program: springbootProject
 * @description:
 * @author: MiaoWei
 * @create: 2021-09-27 10:48
 **/
@Controller
@RequestMapping("/login")
public class LoginController {

    @RequestMapping("/user")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model, HttpSession session) {
        if ("缪威".equals(username) && "123".equals(password)) {
            session.setAttribute("loginUser", username);
            //登录成功跳转成功页面
            return "redirect:/login/main.html";
        }
        model.addAttribute("msg", "账号或密码错误!");
        return "index";
    }
}
