package com.skypro.hw_collectionspartthree.exceptions;

import com.skypro.hw_collectionspartthree.Employee;
import com.skypro.hw_collectionspartthree.Service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> employeeMap;
    private static final int EMPLOYEE_MAX = 9;

    public EmployeeServiceImpl() {
        this.employeeMap = new HashMap<>();
    }

    @Override
    public Employee addEmployee(String firstName, String surName) {
        if (employeeMap.size() == EMPLOYEE_MAX) {
            throw new EmployeeStorageFullException("Превышен лимит количества сотрудников в фирме");
        }
        Employee employee = new Employee(firstName, surName);
        if (employeeMap.containsKey(firstName + surName)) {
            throw new EmployeeAlreadyAddedException("Уже есть такой сотрудник");
        }
        employeeMap.put(firstName + surName, employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String firstName, String surName) {
        Employee employee = new Employee(firstName, surName);
        if (employeeMap.remove(firstName + surName) == null) {
            throw new EmployeeNotFoundException("Сотрудника не существует");
        }
        return employee;
    }

    @Override
    public Employee searchEmployee(String firstName, String surName) {
        Employee employee = new Employee(firstName, surName);
        if (employeeMap.get(firstName + surName) == null) {
            throw new EmployeeNotFoundException("Сотрудник не найден!");
        }
        return employee;
    }

    @Override
    public Collection<Employee> searchAll() {
        return employeeMap.values();
    }
}