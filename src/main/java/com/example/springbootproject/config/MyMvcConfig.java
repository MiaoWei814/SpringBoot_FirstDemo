package com.example.springbootproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 我的mvc配置
 *
 * @author MiaoDaWei
 * @program: springbootProject
 * @description:
 * @author: MiaoWei
 * @create: 2021-09-24 18:29
 * @date 2021/09/27
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    /**
     * 添加视图控制器-视图跳转
     *
     * @param registry 注册表
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //访问首页
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        //登录成功
        registry.addViewController("/login/main.html").setViewName("dashboard");
    }

    /**
     * 区域设置解析器-国际化
     *
     * @return {@link LocaleResolver}
     */
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }

    /**
     * 添加拦截器
     *
     * @param registry 注册表
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor())
                //拦截所有
                .addPathPatterns("/**")
                //不拦截登录页
                .excludePathPatterns("/")
                .excludePathPatterns("/index.html")
                //不拦截登录发起的请求
                .excludePathPatterns("/login/user")
                .excludePathPatterns("/css/**")
                .excludePathPatterns("/js/**")
                .excludePathPatterns("/img/**");
    }
}
