package com.app.service;


import com.app.exception.StudentNotFoundException;
import com.app.model.Student;
import com.app.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudent(Long studentId) {
        Student student=null;
        Optional<Student> studentById = studentRepository.findById(studentId);
        if (studentById.isPresent()) {
             student = studentById.get();

        }else{
            throw new StudentNotFoundException("Student of id: "+studentId+" is not found");
        }
        return student;
    }

    @Override
    public void deleteStudent(Long studentId) {
        Student student=null;
        Optional<Student> studentById = studentRepository.findById(studentId);
        if(studentById.isPresent()){
            studentRepository.deleteById(studentId);
        }else{
            throw new StudentNotFoundException("Student of id: "+studentId+" is not found");
        }

    }

    @Override
    public Student update(Long id, Student student) {
        Student student1=null;
        Optional<Student> studentById = studentRepository.findById(id);
        if(studentById.isPresent()){
            Student student2 = studentById.get();
            student2.setName(student.getName());
            student1 = studentRepository.save(student2);
        }else{
            throw new StudentNotFoundException("Student of id: "+id+" is not found");
        }
        return student1;
    }


}
