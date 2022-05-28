package com.example.demo.service;

import com.example.demo.model.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();
    void addEmployee(Employee employee);
    Employee getEmployeeByID(long id);
    void deleteEmployee(long id);
}
