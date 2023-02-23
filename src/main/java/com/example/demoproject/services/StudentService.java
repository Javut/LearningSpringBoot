package com.example.demoproject.services;

import com.example.demoproject.model.Student;
import com.example.demoproject.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
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

    @Transactional
    public void updateStudent(Long id, String name, String email){

        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalStateException(
                "Student with id"+ id + "does not exist"
        ));
                                                 //Este metodo me permite validar que los dos objetos no sean iguales
        if(name != null && name.length() > 0 && !Objects.equals(student.getName(), name)){
            student.setName(name);
        }

        if(email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)){
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
            if(studentOptional.isPresent()){
                throw new IllegalStateException("Email Taken");
            }
            student.setEmail(email);
        }

    }

}
