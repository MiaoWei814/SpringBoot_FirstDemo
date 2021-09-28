package com.example.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MiaoDaWei
 */
@RestController
public class HelloControllerr {
 
    @RequestMapping("/a")
    public String sayHello(){
        return "Hello Spring Boot!";
    }

}