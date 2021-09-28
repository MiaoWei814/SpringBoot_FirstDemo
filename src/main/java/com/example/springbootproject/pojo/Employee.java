package com.example.springbootproject.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @program: springbootProject
 * @description: 员工表
 * @author: MiaoWei
 * @create: 2021-09-26 19:48
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private Integer id;
    private String lastName;
    private String email;
    private Integer gender;  //0:女 1:男
    private Department department;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date birth;
}
