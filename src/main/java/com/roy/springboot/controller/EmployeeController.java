package com.roy.springboot.controller;

import com.roy.springboot.dao.DepartmentDao;
import com.roy.springboot.dao.EmployeeDao;
import com.roy.springboot.entities.Department;
import com.roy.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;
import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    //查询所有员工返回列表页面
    @GetMapping("/emps")
    public String list(Model model){

        //获取数据
        Collection<Employee> employees = employeeDao.getAll();

        //放入请求域中
        model.addAttribute("emps",employees);

        //thymeleaf拼接字符串 templates/emp/list.html
        return "emp/list";
    }

    //进入到员工添加页面
    @GetMapping("/emp")
    public String toAddPage(Model model){

        //查出所有到部门
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);


        return "emp/add";
    }

    //SpringMVC自动将请求参数和入参对象到属性进行一一绑定；要求请求参数到名字和javabean到属性名一样
    @PostMapping("/emp")
    public String addEmp(Employee emp, BindingResult bindingResult){

        System.out.println(emp);

        employeeDao.save(emp);

        //重定向地址
        return "redirect:/emps";
        //转发地址
        //return "forward:/emps";
    }

    //进入到修改页面
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model){

        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);


        //查出所有到部门
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);

        return "emp/add";
    }

    @PutMapping("/emp")
    public String updateEmp(Employee employee){

        employeeDao.save(employee);

        return "redirect:/emps";
    }

    @DeleteMapping("/emp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id){

        employeeDao.delete(id);

        return "redirect:/emps";
    }
}
