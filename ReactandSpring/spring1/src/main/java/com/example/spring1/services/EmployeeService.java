package com.example.spring1.services;

import com.example.spring1.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee createEmployee(Employee employee);

    List<Employee> getAllEmployees();

    boolean deleteEmployee(long id);

    Employee getEmployee(long id);

    Employee updateEmployee(long id, Employee employee);
}
