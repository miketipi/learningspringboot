package org.example.dao;

import org.example.entity.chapter4entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
    Employee findById(int id);
    Employee save(Employee employee);
    void deleteEmployee(int id);
}
