package com.farhad.example.codekata.birthday_greetings_kata.refactored.infrastructure.repository;

import java.time.LocalDate;
import java.util.List;

import com.farhad.example.codekata.birthday_greetings_kata.refactored.core.Employee;
import com.farhad.example.codekata.birthday_greetings_kata.refactored.core.EmployeeRepository;

public class FileEmployeeRepository implements EmployeeRepository{

    public FileEmployeeRepository(String employeeFile) {
        
    }

    @Override
    public List<Employee> findEmployeesWhoseBirthdayIs(LocalDate today) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findEmployeesWhoseBirthdayIs'");
    }
    
}
