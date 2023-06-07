package com.farhad.example.generic.wildcard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

/**
 * Arrays are covariant while generics are not. it means that Number[] is superType for Integer[]. and Object[] is a superType for any 
 * array( except primitive ones).
 */
@Slf4j
public class Wildcard {

    static class Container<T> {
        private final T value ;
        private List<Integer> numbersList  = new ArrayList<>();
        public Container(T value) {
            this.value = value ;
        }
    
        public List<Integer>  getNumbers() {
            return numbersList ;
        }

        public void addNumber(Integer num) {
            numbersList.add(num);
        }

        // Not compiled
        // public static void traverseNumbersList(Container container) {
        //     for (int num : container.getNumbers()) {
        //         log.info("{}", num);
        //     }
        // }
 
        public static void traverseNumbersList(Container<?> container) {
            for (int num : container.getNumbers()) {
                log.info("{}", num);
            }
        }

        public static void main(String[] args) {
            Container<Integer> container = new Container<Integer>(10);
            container.addNumber(1);
            container.addNumber(2);
            container.addNumber(3);
            Container.traverseNumbersList(container);
        }
    }

    static class Array {
        public static void main(String[] args) {
            
            Number[] nums = new Long[3];
            nums[0] = 1L;
            nums[1] = 2L;
            nums[2] = 3L;

            Object[] objs = nums ;
            objs[2] = "java.lang.ArrayStoreException happens here.";
        }
    }

    static class Generic {

        public static void main(String[] args) {
            
            List<Number> nums  = new ArrayList<Number>();
            List<Long>   longs = new ArrayList<Long>();
            // compilation error
            // nums = longs;
        }
    }
    
    static class Money {
        String currency ;
        long amount;
    }
    interface Employee {
        Money getSalary() ;
    }

    static class Manager implements Employee {

        @Override
        public Money getSalary() {
            return null;
        }
    }

    static class Accountant implements Employee {

        @Override
        public Money getSalary() {
            return null;
        }
    }
    static class SoftwareEngineer implements Employee {

        @Override
        public Money getSalary() {
            return null;
        }
    }

    interface EmployeeService {
        // we must use Producer extends
        Money calculateAverageSalaryBad(Collection<Employee> employees)  ;
        Money calculateAverageSalary(Collection<? extends Employee> employees)  ;
    }

    static class DefaultEmployeeService implements EmployeeService {

        @Override
        public Money calculateAverageSalary(Collection<? extends Employee> employees) {
            return null;
        }

        @Override
        public Money calculateAverageSalaryBad(Collection<Employee> employees) {
            return null;
        }
    }
    
    static class App {
        public static void main(String[] args) {
            List<Manager>           managers    = new ArrayList<>();
            List<Accountant>        accountants = new ArrayList<>();
            List<SoftwareEngineer>  engineers   = new ArrayList<>();
            EmployeeService         employeeService     = new DefaultEmployeeService();

            // Allthese have compilation error
            // employeeService.calculateAverageSalaryBad(managers);
            // employeeService.calculateAverageSalaryBad(accountants);
            // employeeService.calculateAverageSalaryBad(engineers);

            //All these compile successfully
            employeeService.calculateAverageSalary(managers);
            employeeService.calculateAverageSalary(accountants);
            employeeService.calculateAverageSalary(engineers);
        }
    }
}
