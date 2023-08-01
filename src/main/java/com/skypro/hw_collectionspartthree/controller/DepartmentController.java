package com.skypro.hw_collectionspartthree.controller;

import com.skypro.hw_collectionspartthree.Employee;
import com.skypro.hw_collectionspartthree.Service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    @GetMapping("/max-salary")
    public Employee searchMaxSalaryEmployee(@RequestParam int department){
        return departmentService.searchMaxSalaryEmployee(department);
    }
    @GetMapping("/min-salary")
    public Employee searchMinSalaryEmployee(@RequestParam int department){
        return departmentService.searchMaxSalaryEmployee(department);
    }
    @GetMapping ("/all-grouping")
    public Map <Integer, List<Employee>> getAllGroupingByDepartment(@RequestParam int department){
        return departmentService.getAllGroupingByDepartment(department);
    }
}
