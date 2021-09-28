package com.example.springbootproject;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;
import cn.hutool.core.lang.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author MiaoDaWei
 */
//@SpringBootApplication:标注这个类是一个springboot的应用,启动类下的所有资源被导入
@SpringBootApplication
//所建的数据都必须跟启动类同级包下,不然不能扫描到
public class SpringbootProjectApplication {

    public static void main(String[] args) {
        TimeInterval timer = DateUtil.timer();
        //将springboot应用启动
        SpringApplication.run(SpringbootProjectApplication.class, args);
        //启动日志
        Console.log("〓〓〓系统启动成功,耗时{}〓〓〓，当前时间是{}", timer.intervalPretty(), DateUtil.now());

    }

}
