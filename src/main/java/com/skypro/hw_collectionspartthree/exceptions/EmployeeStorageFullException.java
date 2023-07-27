package com.skypro.hw_collectionspartthree.exceptions;

public class EmployeeStorageFullException extends RuntimeException {
    public EmployeeStorageFullException(String message) {
        super(message);
    }
}