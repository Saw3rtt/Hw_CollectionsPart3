package com.skypro.hw_collectionspartthree.controller;


import com.skypro.hw_collectionspartthree.Employee;
import com.skypro.hw_collectionspartthree.EmployeeValidator;
import com.skypro.hw_collectionspartthree.Service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    public final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee add(@RequestParam String firstName, @RequestParam String surName, @RequestParam int department, @RequestParam double salary) {
        EmployeeValidator.checkName(firstName, surName);
        return employeeService.addEmployee(firstName, surName, department, salary);
    }

    @GetMapping("/remove")
    public Employee remove(@RequestParam String firstName, @RequestParam String surName) {
        EmployeeValidator.checkName(firstName,surName);
        return employeeService.removeEmployee(firstName, surName);
    }

    @GetMapping("/search")
    public Employee search(@RequestParam String firstName, @RequestParam String surName) {
        EmployeeValidator.checkName(firstName,surName);
        return employeeService.searchEmployee(firstName, surName);
    }

    @GetMapping
    public Collection<Employee> searchAll() {
        return employeeService.searchAll();
    }
}