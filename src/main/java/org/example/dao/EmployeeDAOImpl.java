package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.example.entity.chapter4entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class EmployeeDAOImpl implements EmployeeDAO {
    private final EntityManager entityManager;

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> createQuery = entityManager.createQuery("from Employee", Employee.class);
        return createQuery.getResultList();
    }

    @Override
    public Employee findById(int id) {
        return entityManager.find(Employee.class,id);
    }

    @Override
    public Employee save(Employee employee) {
        //persist() can use in case insert an object to db, but when it is already a same object in db, it will throw exception => entity might me @Transient
        //merge () can check if an object existed in the DB or not, if not it will insert the object
            Employee dbEmployee = entityManager.merge(employee);
            return dbEmployee;
    }

    @Override
    public void deleteEmployee(int id) {
        Employee deletedEmployee = entityManager.find(Employee.class, id);
        entityManager.remove(deletedEmployee);
    }
}
