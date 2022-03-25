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
    @GetMapping("/get/{id}")
    public ResponseEntity getStudent(@PathVariable Long id){
        return new ResponseEntity(studentService.getStudent(id), HttpStatus.OK);
    }
    @DeleteMapping("/get/{id}")
    public ResponseEntity DeleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return new ResponseEntity("Student of id: "+id+" deleted", HttpStatus.OK);
    }
    @PostMapping("/update/{id}")
    public ResponseEntity updateStudent(@PathVariable Long id, @RequestBody Student student){
        Student updatedStudent = studentService.update(id, student);
        return new ResponseEntity(updatedStudent, HttpStatus.OK);
    }


}
