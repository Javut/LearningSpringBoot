package com.example.demoproject.config;

import com.example.demoproject.model.Student;
import com.example.demoproject.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {

    //CommandLineRunner is an interface used to indicate that a bean should run when it is contained within a SpringApplication.
    // A Spring Boot application can have multiple beans implementing CommandLineRunner. These can be ordered with @Order.

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
           Student jaider = new Student(
                    1L,
                    "Jaider",
                    "Vergara Utria",
                    "javut2010@hotmail.com",
                    28,
                    LocalDate.of(1996,01,24)
            );

           Student raquel = new Student(
                   2l,
                   "Raquel",
                   "Castro",
                   "raquelitadev@gmail.com",
                   29,
                   LocalDate.of(1994, 02, 26)
           );

           repository.saveAll(
                   List.of(jaider, raquel)
           );

        };
    }
}
