package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String viewHomePage(Model model) {

        model.addAttribute("listEmployees", employeeService.getAllEmployees());
        return "index";
    }

    @GetMapping("/addEmployeeForm")
    public String addEmployeeForm(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "add_employee";
    }

    @PostMapping("/addEmployee")
    public String addEmployee(@ModelAttribute("employee") Employee employee) {

        employeeService.addEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("/updateEmployeeForm/{id}")
    public String updateEmployeeForm(@PathVariable(value = "id")long id, Model model){

        Employee employee = employeeService.getEmployeeByID(id);
        model.addAttribute("employee", employee);
        return "update_employee";
    }


}
