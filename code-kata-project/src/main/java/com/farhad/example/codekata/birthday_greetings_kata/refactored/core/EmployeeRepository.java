package com.farhad.example.codekata.birthday_greetings_kata.refactored.core;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeRepository {

    List<Employee> findEmployeesWhoseBirthdayIs(LocalDate today);

}
