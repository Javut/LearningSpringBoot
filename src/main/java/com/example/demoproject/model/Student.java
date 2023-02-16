package com.example.demoproject.model;

import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private Long id;
    private String name;
    private String lastname;
    private String email;
    private int age;
    private LocalDate dob;


}
