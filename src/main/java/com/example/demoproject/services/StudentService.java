package com.example.demoproject.services;

import com.example.demoproject.model.Student;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentService {

    public List<Student> getStudents(){
        return List.of(new Student(
                1L,
                "Jaider",
                "Vergara Utria",
                "javut2010@hotmail.com",
                27,
                LocalDate.of(1996,01,24)

        ));
    }
}
