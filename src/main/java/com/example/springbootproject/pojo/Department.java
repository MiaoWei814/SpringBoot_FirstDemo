package com.example.springbootproject.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: springbootProject
 * @description: 部门表
 * @author: MiaoWei
 * @create: 2021-09-26 19:46
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    private Integer id;
    private String departmentName;
}
