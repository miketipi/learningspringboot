package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.entity.chapter4entity.Employee;
import org.example.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
@AllArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;



    @GetMapping("/list")
    public String listEmployees(Model model){
        //get all Employees
        List<Employee> employees = employeeService.findAll();

        //add to model
        model.addAttribute("employees", employees);
        return "list-employees";
    }
}
