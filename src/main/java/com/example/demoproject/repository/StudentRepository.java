package com.example.demoproject.repository;

import com.example.demoproject.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> { //T el tipo de objeto con el que queremos que este repositorio trabaje , el segundo parametro es para el tipo de datos del Id

}
