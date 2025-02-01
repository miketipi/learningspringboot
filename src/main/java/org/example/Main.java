package org.example;

import org.example.dao.StudentDAO;
import org.example.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

//    @Bean
//    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
//        return runner -> {
//            System.out.println("This is the command line runner");
////            createStudent(studentDAO);
////            readStudent(studentDAO);
////            getAllStudent(studentDAO);
////            updateStudent(studentDAO);
////            deleteStudent(studentDAO);
//        };
//    }

    private void createStudent(StudentDAO studentDAO) {
        Student tempStudent = new Student("Paul", "Doe", "alo");
        studentDAO.save(tempStudent);
        System.out.println("Student saved");
    }

    private Student readStudent(StudentDAO studentDAO) {
        System.out.println("Day la thong tin cua user thu");
        Student temp = studentDAO.findById(1);
        System.out.println("thong tin user" + temp.toString());
        return temp;
    }

    private void getAllStudent(StudentDAO studentDAO) {
        List<Student> theStudents = studentDAO.findAll();
        for (Student tempStu : theStudents) {
            System.out.println(tempStu);
        }
    }
    private void updateStudent(StudentDAO studentDAO){
        Student student = studentDAO.findById(1);
        String firstName = student.getFirstName();
        student.setFirstName("PhucVTT");
        studentDAO.update(student);
        System.out.println("FirstName Changed from" + firstName + " to " + student.getFirstName());
    }
    private void deleteStudent(StudentDAO studentDAO){
        studentDAO.delete(1);
        System.out.println("Student with id " + 1 + " deleted");
    }
}