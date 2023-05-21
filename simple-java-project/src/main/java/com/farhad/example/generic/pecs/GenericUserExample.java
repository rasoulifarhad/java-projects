package com.farhad.example.generic.pecs;

import java.util.List;

import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

public class GenericUserExample {

    public static void main(String[] args) {
        
    }

    @Getter
    @ToString
    static class User {
        final String name ;
        public User(String name){
            this.name = name ;
        }
    }

    static class Customer extends User {
    
        public Customer(String name) {
            super(name);
        }
    }
    
    static class Operator extends User {

        public Operator(String name) {
            super(name);
        }
    }

    static class FixOperator extends Operator {
        public FixOperator(String name) {
            super(name);
        }
    }
    
    static class VipCustomer extends Customer {
        public VipCustomer(String name) {
            super(name);
        }
    }
    
    @Slf4j
    static class UserUtils {
    
        public static void sendEmails(List<User> users ) {
            for (User user : users) {
                log.info("Sending email to: {}", user);
            }
        }
    
        public static void sendEmailsToCustomers(List<Customer> customers ) {
            for (Customer customer : customers) {
                log.info("Sending email to customer: {}", customer);
            }
        }
    
        public static void sendEmailsToOperators(List<Operator> operators) {
            for (Operator operator : operators) {
                log.info("Sending email to operator: {}", operator);
            }
        }
    
        public static void sendEmailsGeneric(List<? extends User> users) {
            for (User user : users) {
                log.info("Sending email to: {}", user);
            }
        }
    
        public static void addUsersFromMarketingDepartment(List<Operator>  users) {
            users.add(new Operator("operator 1"));
            users.add(new Operator("operator 2"));
        }
    
        public static void addUsersFromMarketingDepartmentGeneric(List<? super Operator>  users) {
            users.add(new Operator("operator 1"));
            users.add(new Operator("operator 2"));
            users.add(new FixOperator("fixOperator 1"));
        }
    
        public static void addOperators(List<? super Operator>  list,Operator... users) {
            for (Operator operator : users) {
                list.add(operator);
            }
        }
    
        public static void addCustomers(List<? super Customer>  list,Customer... customers) {
            for (Customer customer : customers) {
                list.add(customer);
            }
        }
    }
    
}
