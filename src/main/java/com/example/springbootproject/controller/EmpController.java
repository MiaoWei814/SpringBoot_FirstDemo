package com.example.springbootproject.controller;

import com.example.springbootproject.dao.DepartmentDao;
import com.example.springbootproject.dao.EmployeeDao;
import com.example.springbootproject.pojo.Department;
import com.example.springbootproject.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Collection;

/**
 * @program: springbootProject
 * @description: 员工Controller
 * @author: MiaoWei
 * @create: 2021-09-27 19:25
 **/
@Controller
public class EmpController {
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private DepartmentDao departmentDao;


    /**
     * 列表
     *
     * @param model 模型
     * @return {@link String}
     */
    @RequestMapping("/emps")
    public String list(Model model) {
        Collection<Employee> all = employeeDao.getAll();
        model.addAttribute("emps", all);
        return "/emp/list";
    }

    /**
     * 来添加页面
     *
     * @param model 模型
     * @return {@link String}
     */
    @GetMapping("/emp")
    public String toAddPage(Model model) {
        //查出所有部门的信息
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments", departments);
        return "emp/add";
    }

    /**
     * 添加
     *
     * @return {@link String}
     */
    @PostMapping("/emp")
    public String addEmp(Employee employee) {
        employeeDao.save(employee);
        //因为thymeleaf规则是不走带有重定向或者转发的前缀,所以这里会直接在地址栏重定向
        return "redirect:/emps";
    }

    /**
     * 更新页面
     *
     * @param id id
     * @return {@link String}
     */
    @GetMapping("/emp/{id}")
    public String toUpdatePage(@PathVariable(name = "id") Integer id,Model model) {
        //查询出原来的数据
        Employee employeeById = employeeDao.getEmployeeById(id);
        model.addAttribute("emp", employeeById);
        //查出所有部门的信息
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments", departments);
        return "emp/update";
    }

    /**
     * 更新emp
     *
     * @param employee 员工
     * @return {@link String}
     */
    @PostMapping("/updateEmp")
    public String toUpdateEmp(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    /**
     * 删除员工
     *
     * @param id id
     * @return {@link String}
     */
    @GetMapping("/delEmp/{id}")
    public String deleteEmployee(@PathVariable(name = "id") Integer id) {
        employeeDao.delete(id);
        return "redirect:/emps";
    }

    /**
     * 注销
     *
     * @param session 会话
     * @return {@link String}
     */
    @GetMapping("/user/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/index.html";
    }
}
