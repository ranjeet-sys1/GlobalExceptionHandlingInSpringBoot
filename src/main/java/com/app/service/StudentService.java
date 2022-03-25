package com.app.service;

import com.app.model.Student;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface StudentService {
    Student save(Student student);
    List<Student> getStudents();
    Student getStudent(Long studentId);
    void deleteStudent(Long studentId);
    Student update(Long id,Student student);
}
