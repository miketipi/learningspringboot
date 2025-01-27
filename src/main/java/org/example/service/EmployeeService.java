package org.example.service;

import org.example.entity.chapter4entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee save (Employee employee);
    void removeEmployee(int id);
    Employee findById(int id);
}
