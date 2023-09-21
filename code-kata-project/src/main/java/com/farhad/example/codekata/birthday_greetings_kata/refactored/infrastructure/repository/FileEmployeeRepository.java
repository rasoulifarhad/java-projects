package com.farhad.example.codekata.birthday_greetings_kata.refactored.infrastructure.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.farhad.example.codekata.birthday_greetings_kata.refactored.core.Employee;
import com.farhad.example.codekata.birthday_greetings_kata.refactored.core.EmployeeRepository;
import com.farhad.example.codekata.birthday_greetings_kata.refactored.core.EmployeesFile;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FileEmployeeRepository implements EmployeeRepository{
   
    private final String path;    

    @Override
    public List<Employee> findEmployeesWhoseBirthdayIs(LocalDate today) {
        return allEmployees().stream()
                    .filter(e -> e.isBirthday(today))
                    .collect(Collectors.toList());
    }

    private List<Employee> allEmployees() {
        return EmployeesFile.
                    loadFrom(path)
                    .extractEmployees();
    }
     
}
