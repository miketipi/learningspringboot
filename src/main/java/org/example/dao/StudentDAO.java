package org.example.dao;

import org.example.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);

    Student findById (Integer id);

    List<Student> findAll();

    void update(Student theStudent);
    void UpdateWithInfo();

    void delete(Integer id);
}
