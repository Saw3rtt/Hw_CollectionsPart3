package com.skypro.hw_collectionspartthree;

import java.util.Objects;

public class Employee {

    private String firstName;
    private String surName;

    public Employee(String firstName, String surName) {
        this.firstName = firstName;
        this.surName = surName;
    }

    @Override
    public String toString() {
        return "Employee " +
                "firstName='" + firstName + '\'' +
                ", lastName='" + surName + '\'';
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return surName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(surName, employee.surName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, surName);
    }
}
