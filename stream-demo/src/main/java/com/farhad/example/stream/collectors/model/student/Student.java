package com.farhad.example.stream.collectors.model.student;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private String name;
    private String surname;
    private String city;
    private double avgGrade;
    private int age;

    @Override
    public String toString() {
        return name + " " + surname;
    }

    public static List<Student> STUDENTS = students();

    private static List<Student> students() {
        return Arrays.asList(
            new Student("John", "Smith", "Miami", 7.38, 19),
            new Student("Jane", "Miles", "New York", 8.4, 21),
            new Student("Michael", "Peterson", "New York", 7.5, 20),
            new Student("Gabriella", "Robertson", "Miami", 9.1, 20),
            new Student("Kyle", "Miller", "Miami", 9.83, 20));
    }  

    public List<String> studentNames() {
        return students().stream()
                    .map(Student::getName)
                    .collect(Collectors.toList());
    }


}
