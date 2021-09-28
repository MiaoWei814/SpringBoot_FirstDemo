package com.example.springbootproject.config;


import org.aopalliance.intercept.Interceptor;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: springbootProject
 * @description: 登录的拦截器
 * @author: MiaoWei
 * @create: 2021-09-27 18:38
 **/
public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object loginUser = request.getSession().getAttribute("loginUser");
        //没有登录就拦截
        if (loginUser == null) {
            request.setAttribute("msg", "没有权限,请重新登录!");
            request.getRequestDispatcher("/index.html").forward(request, response);
            return false;
        }
        return true;
    }
}
