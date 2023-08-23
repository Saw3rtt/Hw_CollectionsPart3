package com.skypro.hw_collectionspartthree.Service;

import com.skypro.hw_collectionspartthree.Employee;
import com.skypro.hw_collectionspartthree.exceptions.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee searchMaxSalaryEmployee(int department) {
        return employeeService.searchAll().stream()
                .filter(employee -> employee.getDepartment() == department)
                .max(Comparator.comparingDouble(employee -> employee.getSalary())).orElseThrow(() ->
                        new EmployeeNotFoundException("Нет сотрудников"));
    }

    @Override
    public Employee searchMinSalaryEmployee(int department) {
        return employeeService.searchAll().stream()
                .filter(employee -> employee.getDepartment() == department)
                .min(Comparator.comparingDouble(employee -> employee.getSalary())).orElseThrow(() ->
                        new EmployeeNotFoundException("Нет сотрудников"));
    }


    @Override
    public Collection<Employee> searchAllEmployees(int department) {
        return employeeService.searchAll().stream()
                .filter(employee -> employee.getDepartment() == department)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> getAllGroupingByDepartment() {
        return employeeService.searchAll().stream()
                .collect(Collectors.groupingBy(employee -> employee.getDepartment()));
    }
}

