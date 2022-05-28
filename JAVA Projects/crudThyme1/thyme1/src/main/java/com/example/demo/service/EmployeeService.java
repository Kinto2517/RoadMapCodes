package com.example.demo.service;

import com.example.demo.model.Employee;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();
    void addEmployee(Employee employee);
    Employee getEmployeeByID(long id);
    void deleteEmployee(long id);
    Page<Employee> findPaginated(int pageNo, int pageSize, String sortField, String sortDireciton);
}
