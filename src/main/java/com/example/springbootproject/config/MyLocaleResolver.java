package com.example.springbootproject.config;

import cn.hutool.core.text.CharSequenceUtil;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @program: springbootProject
 * @description: 自定义国际化资源配置
 * @author: MiaoWei
 * @create: 2021-09-27 16:52
 **/
public class MyLocaleResolver implements LocaleResolver {
    /**
     * 解决语言环境
     *
     * @param request 请求
     * @return {@link Locale}
     */
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        //获取请求中的语言参数
        String i18nMessage = request.getParameter("i18nMessage");
        //获取默认的地区
        Locale locale = Locale.getDefault();

        if (CharSequenceUtil.isNotEmpty(i18nMessage)) {
            //拆分语言参数: zh_CN en_US
            String[] split = i18nMessage.split("_");
            //国家,地区
            locale = new Locale(split[0], split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
