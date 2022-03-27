package com.app.controller;

import com.app.model.Student;
import com.app.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Locale;
import java.util.UUID;

@RestController
@RequestMapping("/stu/v1/")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private MessageSource messageSource;
    @PostMapping("/save")
    public ResponseEntity saveStudent(@Valid @RequestBody Student student){
       return new ResponseEntity(studentService.save(student), HttpStatus.CREATED);
    }
    @GetMapping("/get")
    public ResponseEntity getStudents(){
        return new ResponseEntity(studentService.getStudents(), HttpStatus.FOUND);
    }
    @GetMapping("/get/{id}")
    public EntityModel<Student> getStudent(@PathVariable Long id){
        Student student = studentService.getStudent(id);
        EntityModel<Student> model=EntityModel.of(student);
        WebMvcLinkBuilder linkToUsers=WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getStudents());
        model.add(linkToUsers.withRel("all-students"));
        return model;
    }
    @DeleteMapping("/get/{id}")
    public ResponseEntity DeleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return new ResponseEntity("Student of id: "+id+" deleted", HttpStatus.OK);
    }
    @PostMapping("/update/{id}")
    public ResponseEntity updateStudent(@PathVariable Long id, @Valid @RequestBody Student student){
        Student updatedStudent = studentService.update(id, student);
        return new ResponseEntity(updatedStudent, HttpStatus.OK);
    }
    @GetMapping("/i18n")
    public String InternationalizationApi(){
            //@RequestHeader(name="Accept-Language",required = false) Locale locale){
        return messageSource.getMessage("good.morning.message",null,"default messages", LocaleContextHolder.getLocale());
    }


}
