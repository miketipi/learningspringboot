package org.example.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.example.dao.EmployeeDAO;
import org.example.entity.chapter4entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

// @Transactional use on service methods, if it is used on repository method , remove it
@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeDAO employeeDAO;
    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Transactional
    @Override
    public Employee save(Employee employee) {
        return employeeDAO.save(employee);
    }

    @Transactional
    @Override
    public void removeEmployee(int id) {
        employeeDAO.deleteEmployee(id);
    }

    @Override
    public Employee findById(int id) {
        return employeeDAO.findById(id);
    }
}
