package com.farhad.example.collections.ordering;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import com.farhad.example.models.Name;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.datafaker.Faker;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements Comparable<Employee>{

    private Name name;
    private int number;
    private Date hireDate;
    
    // natural ordering of Employee instances  is Name ordering 
    @Override
    public int compareTo(Employee o) {
        return name.compareTo(o.getName());
    }
    
    public static class factory {
        static final AtomicInteger id = new AtomicInteger();
        static Faker faker = new Faker();

        static List<Name> names = faker.collection( () -> new Name(faker.name().firstName(), faker.name().lastName()) ).len(4).generate();
        // private static String [] names = new String[] {"John", "Jane", "Mary", "Mike", "Bob", "Sue", "Richard", "Robert", "Martin", "Arvind"};
        private static Date hireDate() {
            return faker.date().between(
                        Date.from(
                            LocalDateTime.now()
                                            .minusYears(8)
                                            .atZone(ZoneId.systemDefault())
                                            .toInstant()),
                        Date.from(Instant.now()));
        }          
        
        private static int number(){
            return id.incrementAndGet();
        }

        public static List<Employee> employees() {
            return names.stream()
                            .map(name -> {
                                return new Employee(name, number(), hireDate());
                            } )
                            .collect(Collectors.toList());
        }
    }

}
