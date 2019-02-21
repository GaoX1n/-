package com.baizhi.service;

import com.baizhi.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> selectAll();
    public int addEmployee(String name,int salary,int age);

    int deleteById(int id);

    Employee selectById(int id);

    int update(Employee employee);
}
