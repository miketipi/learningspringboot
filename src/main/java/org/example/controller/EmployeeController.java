package org.example.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.entity.chapter4entity.Employee;
import org.example.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/employees")
@AllArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;


    @GetMapping("/list")
    public String listEmployees(Model model) {
        //get all Employees
        List<Employee> employees = employeeService.findAll();

        //add to model
        model.addAttribute("employees", employees);
        return "list-employees";
    }

    @GetMapping("/updateEmployee")
    public String updateEmployeeForm(Model model, @RequestParam int employeeId) {
        //create model to add employees
        Employee theEmployee = new Employee();
        theEmployee = employeeService.findById(employeeId);
        model.addAttribute("employee", theEmployee);
        return "update-employee-form";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        Employee theEmployee = new Employee();
        model.addAttribute("employee", theEmployee);
        return "create-new-employee-form";
    }

    @GetMapping("/deleteEmployee")
    public String deleteEmployees(@RequestParam int employeeId) {
        employeeService.removeEmployee(employeeId);
        log.debug("Remove employee with id {}", employeeId);
        return "redirect:/employees/list";
    }


    @PostMapping("/save")
    public String saveEmployees(Employee employee) {
        employeeService.save(employee);
        log.debug("Saving Employee With Name : {} and Email : {}", employee.getFirstName() + employee.getLastName(), employee.getEmail());
        return "redirect:/employees/list";
        // this is a redirect, we use it to prevent duplicate submissions
    }
}
