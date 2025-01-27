package org.example.controller;

import org.example.entity.chapter4entity.StudentErrorResponse;
import org.example.entity.chapter4entity.StudentNotFoundException;
import org.example.entity.chapter4entity.StudentTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentTestRestController {
    //use for getAll, not a specific student
    @GetMapping("/students")
    public List<StudentTest> getStudents() {
        List<StudentTest> studentTests = new ArrayList<>();
        studentTests.add(new StudentTest("Phuc", "Vo"));
        studentTests.add(new StudentTest("Tram", "Nguyen"));
        studentTests.add(new StudentTest("Phuong", "Nguyen"));
        studentTests.add(new StudentTest("Linh", "Pham"));
        return studentTests;
    }

    @GetMapping("/students/{studentId}")
    public StudentTest getStudent(@PathVariable int studentId) {
        if (studentId >= 100) throw new StudentNotFoundException("Student is not found - " + studentId);
        return new StudentTest("New", "Me");
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleStudentNotFoundException (StudentNotFoundException exception){
        StudentErrorResponse resp = new StudentErrorResponse();
        resp.setStatus(HttpStatus.NOT_FOUND.value());
        resp.setMessage(exception.getMessage());
        resp.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);
    }
}
