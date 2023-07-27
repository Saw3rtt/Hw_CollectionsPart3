package com.skypro.hw_collectionspartthree.Service;
import com.skypro.hw_collectionspartthree.Employee;

import java.util.Collection;
import java.util.List;

public interface EmployeeService {
    Employee addEmployee(String firstname, String surname);

    Employee removeEmployee(String firstName, String surName);

    Employee searchEmployee(String firstName, String surName);

    Collection<Employee> searchAll();
}