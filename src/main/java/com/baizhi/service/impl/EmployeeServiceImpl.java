package com.baizhi.service.impl;

import com.baizhi.dao.EmployeeMapper;
import com.baizhi.entity.Employee;
import com.baizhi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;
    @Override
    public List<Employee> selectAll() {
        return employeeMapper.selectAll();
    }

    @Override
    public int addEmployee(String name, int salary, int age) {
        Employee employee = new Employee();
        employee.setAge(age);
        employee.setName(name);
        employee.setSalary(salary);
        int insert = employeeMapper.insert(employee);
        return insert;
    }

    @Override
    public int deleteById(int id) {
        int i = employeeMapper.deleteByPrimaryKey(id);
        return i;
    }

    @Override
    public Employee selectById(int id) {
        return employeeMapper.selectByPrimaryKey(id);
    }

    @Override
    public int update(Employee employee) {
        return employeeMapper.updateByPrimaryKey(employee);
    }
}
