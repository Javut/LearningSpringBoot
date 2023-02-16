package com.example.demoproject.services;

import com.example.demoproject.model.Student;
import com.example.demoproject.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getStudents(){
       return studentRepository.findAll();
    }
}
