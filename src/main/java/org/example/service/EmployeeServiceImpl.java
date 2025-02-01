package org.example.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.example.dao.EmployeeDAO;
import org.example.entity.chapter4entity.Employee;
import org.example.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

// @Transactional use on service methods, if it is used on repository method , remove it
@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeDAO employeeDAO;
    private final EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
//        return employeeDAO.findAll();
        //use spring data jpa instead of jpa api
        return employeeRepository.findAll();
    }

    @Transactional
    @Override
    public Employee save(Employee employee) {
        //return employeeDAO.save(employee);
        return employeeRepository.save(employee);
    }

    @Transactional
    @Override
    public void removeEmployee(int id) {
        employeeRepository.deleteById(id);
        // employeeDAO.deleteEmployee(id);
    }

    @Override
    public Employee findById(int id) {
        return employeeDAO.findById(id);
    }
}
