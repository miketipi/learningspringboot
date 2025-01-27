package org.example.exceptionhandler;

import org.example.entity.chapter4entity.EmployeeNotFoundException;
import org.example.entity.chapter4entity.EmployeeNotFoundResponse;
import org.example.entity.chapter4entity.StudentErrorResponse;
import org.example.entity.chapter4entity.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleStudentNotFoundException(StudentNotFoundException exception) {
        StudentErrorResponse resp = new StudentErrorResponse();
        resp.setStatus(HttpStatus.NOT_FOUND.value());
        resp.setMessage(exception.getMessage());
        resp.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<EmployeeNotFoundResponse> handleEmployeeNotFoundException(EmployeeNotFoundException exc){
        EmployeeNotFoundResponse resp = new EmployeeNotFoundResponse();
        resp.setStatus(HttpStatus.NOT_FOUND.value());
        resp.setMessage(exc.getMessage());
        resp.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);

    }
}
