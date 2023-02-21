package com.example.demoproject.services;

import com.example.demoproject.model.Student;
import com.example.demoproject.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getStudents(){
       return studentRepository.findAll();
    }

    public void registerNewStudentService(Student student){
        Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
        if(studentByEmail.isPresent()){
            throw new IllegalStateException("EMAIL TAKEN");
        }else {
            System.out.printf("Existe un email");
            studentRepository.save(student);
        }
    }

    public void deleteStudentByIdService(Long id){
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if(optionalStudent.isEmpty()){
            throw new IllegalStateException("student with id "+ id + "no found");
        }
        studentRepository.deleteById(id);
    }
}
