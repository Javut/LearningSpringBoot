package com.example.demoproject.controller;

import com.example.demoproject.model.Student;
import com.example.demoproject.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @PostMapping
    public void registerNewStudentController(@RequestBody Student student){
        studentService.registerNewStudentService(student);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudentByIdController(@PathVariable("id") Long id){
        studentService.deleteStudentByIdService(id);
        return ResponseEntity.noContent().build();
    }


}
