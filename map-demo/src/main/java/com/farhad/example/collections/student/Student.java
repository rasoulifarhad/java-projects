package com.farhad.example.collections.student;

import static com.farhad.example.collections.student.GradeLevel.findLevelByName;
import static com.farhad.example.collections.student.GradePointAverage.findGPAByName;
import static com.farhad.example.collections.student.Hobby.findHobbyByName;
import static com.farhad.example.collections.student.Major.findMajorByName;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Student {

    private static final AtomicLong idGenerator = new AtomicLong();

    private final long id;
    private final String name;
    private List<Hobby> hobbies = new ArrayList<>();
    private final GradeLevel level;
    private final GradePointAverage gpa;
    private List<Major> majors = new ArrayList<>();

    public boolean hasHobby(String name) {
        return this.hobbies.stream()
                    .anyMatch(h -> name.equals(h.getName()) );
    }

    public boolean hasMajor(String name) {
        return this.majors.stream()
                    .anyMatch(m -> name.equals(m.getName()) );
    }

    public void addHobby(Hobby hobby) {
        this.hobbies.add(hobby);
    }

    public void addMajor(Major major) {
        this.majors.add(major);
    }

    public static void main(String[] args) {
    }

    private static Student student(Long id) {
        return ALL_STUDENTS.stream()    
                                .filter(s -> s.getId() == id)
                                .findFirst()
                                .get();    
    }
    
    public static StudentData makeStudentData(Long id) {
        return ALL_STUDENTS.stream()
                                .filter(s -> s.getId() == id)
                                .map(s -> {return new StudentData(s.getName(), 
                                                            s.hobbies, 
                                                            s.getLevel(), 
                                                            s.getGpa(), 
                                                            s.getMajors());
                                    }
                                )
                                .findFirst()
                                .get();
    }

    public static Student makeInstance(StudentData studentData) {
        List<Hobby> hobbies = studentData.getHobbies()
                                            .stream()
                                            .map(hobbyName -> findHobbyByName(hobbyName))
                                            .collect(Collectors.toList());
        List<Major> majors = studentData.getMajors()
                                            .stream()
                                            .map(name -> findMajorByName(name) )
                                            .collect(Collectors.toList());

        Student student = new Student(idGenerator.incrementAndGet(), 
                                    studentData.getName(), 
                                    hobbies, 
                                    findLevelByName(studentData.getLevel()), 
                                    findGPAByName(studentData.getGpa()), 
                                    majors);
        return student;
    }

    private static final List<Student> ALL_STUDENTS = new ArrayList<>();

    static {
        // Valid student. No optional data supplied.
        ALL_STUDENTS.add(new Student(1L, "Joe Good", findLevelByName("Freshman"), findGPAByName("4.0")));
        // Valid student with optional data.
        ALL_STUDENTS.add(new Student(2L, "Alice Good", findLevelByName("Sophomore"), findGPAByName("4.0")));

        student(2L).addHobby(findHobbyByName("Biking"));
        student(2L).addHobby(findHobbyByName("Surfing"));
        student(2L).addMajor(findMajorByName("Chemistry"));
        student(2L).addMajor(findMajorByName("Physics"));
        // Invalid student. Password is too short.
        ALL_STUDENTS.add(new Student(3L, "Frank Bad", findLevelByName("Freshman"), findGPAByName("4.0")));
    }
}
