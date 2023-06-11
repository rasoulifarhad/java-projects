package com.farhad.example.models.person;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class Person {
    private UUID id;
    private String name;
    private Gender gender;
    private int age;
    private Address address;
    private LocalDateTime lastModified = LocalDateTime.now();
}
