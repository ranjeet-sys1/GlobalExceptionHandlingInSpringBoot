package com.app.controller;

import com.app.model.Student;
import com.app.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/stu/v1/")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @PostMapping("/save")
    public ResponseEntity saveStudent(@RequestBody Student student){
       return new ResponseEntity(studentService.save(student), HttpStatus.CREATED);
    }
    @GetMapping("/get")
    public ResponseEntity getStudents(){
        return new ResponseEntity(studentService.getStudents(), HttpStatus.FOUND);
    }
    @PostMapping("/get/{u}")
    public ResponseEntity getStudent(@PathVariable UUID uuid){
        return new ResponseEntity(studentService.getStudent(uuid), HttpStatus.FOUND);
    }
}
