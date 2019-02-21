package com.baizhi.controller;

import com.baizhi.entity.Employee;
import com.baizhi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("emsEmployee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @RequestMapping("selectAll")
    public String  selectAll(Map map){
        List<Employee> employees = employeeService.selectAll();
        map.put("list",employees);
        return "forward:/emplist.jsp";
    }
    @RequestMapping("addEmployee")
    public String addEmployee(String name,int salary,int age){
        try {
            int i = employeeService.addEmployee(name, salary, age);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/emsEmployee/selectAll";
    }
    @RequestMapping("deleteById")
    public String deleteEmployee(int id){
        try {
            int i = employeeService.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/emsEmployee/selectAll";
    }
    @RequestMapping("selectById")
    public String selectOneEmployee(int id,Map map){
        try {
            Employee emp= employeeService.selectById(id);
            map.put("emp",emp);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "updateEmp";
    }
    @RequestMapping("update")
    public String updateEmployee(Employee employee){

        try {
            int i=employeeService.update(employee);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/emsEmployee/selectAll";
    }
}
