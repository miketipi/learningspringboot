package org.example.repository;

import org.example.entity.chapter4entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//use this annotation to change source path for spring data rest
//@RepositoryRestResource(path = "members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    //spring data rest controller can suplly pagination, default is 20 per page
    //it can be access with a query param
    //for example http://localhost:8080/employees?page=0
}
