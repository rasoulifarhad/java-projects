package com.farhad.example.codekata.birthday_greetings_kata.refactored.core;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EmployeesFile {
    
    private final Iterator<String> linesIterator;

    public static EmployeesFile loadFrom(String path) {
        return new EmployeesFile(FileReader.readSkippingHeader(path));
    }

    public List<Employee> extractEmployees() {
        List<Employee> employees = new ArrayList<>();
        while (linesIterator.hasNext()) {
            String[] employeeData = linesIterator.next().split(", ");
            Employee employee = new Employee(employeeData[1], employeeData[0], employeeData[2], employeeData[3]);
            employees.add(employee);
        }
        return employees;
    }

    private static class FileReader {

        public static Iterator<String> readSkippingHeader(String pathString) {
            Path path = Paths.get(pathString);
            try {
                return skipHeader(readFile(path));
            } catch (IOException e) {
                throw new CannotReadEmployeesException(
                    String.format("cannot loadFrom file = '%s'", path.toAbsolutePath()),
                    e );         
                }
        }

        private static Iterator<String>  readFile(Path path) throws IOException {
            return Files.readAllLines(path).iterator();
        }

        private static Iterator<String>  skipHeader(Iterator<String> it) {
            it.next();
            return it;
        }
    }
}
