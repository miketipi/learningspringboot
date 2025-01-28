//package org.example.controller;
//
//import lombok.AllArgsConstructor;
//import org.example.entity.chapter4entity.Employee;
//import org.example.entity.chapter4entity.EmployeeNotFoundException;
//import org.example.service.EmployeeService;
//import org.springframework.http.RequestEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api")
//@AllArgsConstructor
//public class EmployeeRestcontroller {
//    private final EmployeeService employeeService;
//
//    @GetMapping("/employees")
//    public List<Employee> getAllEmployees() {
//        return employeeService.findAll();
//    }
//
//    @GetMapping("/employees/{employeeId}")
//    public Employee findById(@PathVariable int employeeId) {
//        if (employeeService.findAll().size() <= employeeId) throw new EmployeeNotFoundException("Khong tim thay nhan vien voi id : " + employeeId);
//        return employeeService.findById(employeeId);
//    }
//
//    @PostMapping("/employees")
//    public void addEmployees(RequestEntity<Employee> requestEntity) {
//        employeeService.save(requestEntity.getBody());
//    }
//
//    @PutMapping("/employees")
//    public void updateEmployees(RequestEntity<Employee> requestEntity) {
//        employeeService.save(requestEntity.getBody());
//    }
//
//    @DeleteMapping("/employees/{employeeId}")
//    public void deleteEmployee(@PathVariable Integer employeeId) {
//        if (employeeService.findAll().size() <= employeeId) throw new EmployeeNotFoundException("Khong tim thay nhan vien voi id : " + employeeId);
//        employeeService.removeEmployee(employeeId);
//    }
//}
