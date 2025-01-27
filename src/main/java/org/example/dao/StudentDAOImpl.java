package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.example.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class StudentDAOImpl implements StudentDAO {
    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, 1);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    //update with query
    @Override
    @Transactional
    public void UpdateWithInfo() {
        int numsRowUpdated = entityManager.createQuery("").executeUpdate();

    }

    @Transactional
    @Override
    public void delete(Integer id) {
        //remove function will receive an object
        Student theOne = entityManager.find(Student.class, id);
        entityManager.remove(theOne);
        System.out.println("User Removed");
    }

    private final EntityManager entityManager;

}
