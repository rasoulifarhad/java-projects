package com.farhad.example.generic.pecs;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.farhad.example.generic.pecs.GenericUserExample.Customer;
import com.farhad.example.generic.pecs.GenericUserExample.FixOperator;
import com.farhad.example.generic.pecs.GenericUserExample.Operator;
import com.farhad.example.generic.pecs.GenericUserExample.User;
import com.farhad.example.generic.pecs.GenericUserExample.UserUtils;
import com.farhad.example.generic.pecs.GenericUserExample.VipCustomer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GenericUserExampleTest {
    
    @Test
    public void sendEmailsToUsersTest() {
        List<User> users =  Arrays.asList(new User("farhad"),  new User("stranger")) ;;
        UserUtils.sendEmails( users);
    }

    @Test
    public void sendEmailsToCustomers() {
        List<Customer> customers = Arrays.asList(new Customer("customer1"), new Customer("customer2")) ;
        // compile error
        // UserUtils.sendEmails(customers);
        UserUtils.sendEmailsToCustomers(customers);

        List<User> users =  Arrays.asList(new Customer("customer1"), new Customer("customer2")) ;
        UserUtils.sendEmails(users);
    }

    @Test
    public void sendEmailsToOperators() {
        List<Operator> operators = Arrays.asList(new Operator("operator1"), new Operator("operator2")) ;
        // compile error
        // UserUtils.sendEmails(operators);
        UserUtils.sendEmailsToOperators(operators);

        List<User> users =  Arrays.asList(new Operator("operator1"), new Operator("operator2")) ;
        UserUtils.sendEmails(users);
    }

    @Test
    public void sendEmailsGenericTest() {
        List<Customer> customers = Arrays.asList(new Customer("customer1"), new Customer("customer2"));
        List<Operator> operators = Arrays.asList(new Operator("operator1"), new Operator("operator2"));
        List<User> users = Arrays.asList(new User("user1"), new User("userU2"));
        UserUtils.sendEmailsGeneric(customers);
        UserUtils.sendEmailsGeneric(operators);
        UserUtils.sendEmailsGeneric(users);
    } 

    @Test
    public void addUsersFromMarketingDepartmentTest() {
        List<Operator> operators =  new ArrayList<>();
        operators.add(new Operator("operator 0"));
        UserUtils.addUsersFromMarketingDepartment(operators);
        operators.stream().forEach(operator -> log.info("Added: {}", operator) );

        List<User> users = new ArrayList<>() ;
        users.add(new Operator("operator 0"));
        users.add(new Customer("customer 0"));
        // compile error
        // UserUtils.addUsersFromMarketingDepartment(users);
        // users.stream().forEach(user -> log.info("Added: {}", user) );

    }

    @Test
    public void addUsersFromMarketingDepartmentGenericTest() {
        List<Operator> operators =  new ArrayList<>();
        operators.add(new Operator("operator 0"));
        UserUtils.addUsersFromMarketingDepartmentGeneric(operators);
        operators.stream().forEach(operator -> log.info("Added: {}", operator) );

        List<User> users = new ArrayList<>() ;
        users.add(new Operator("operator 0"));
        users.add(new Customer("customer 0"));
        UserUtils.addUsersFromMarketingDepartmentGeneric(users);
        users.stream().forEach(user -> log.info("Added: {}", user) );
    }

    @Test
    public void addOperatorsTest() {
        List<Operator> operators = new ArrayList<>();
        UserUtils.addOperators(operators, new Operator("operator 1"), new FixOperator("fix operator 4"));
        operators.stream().forEach(o -> log.info("Added: {}", o) );
    }

    @Test
    public void addCustomersTest() {
        List<Customer> customers = new ArrayList<>();
        UserUtils.addCustomers(customers, new Customer("customer1"), new VipCustomer("vip customer 1"));
        customers.stream().forEach(c -> log.info("added: {}", c));
    }

    @Test
    public void CovarianceTest() {
        List<Integer> ints = new ArrayList<>();
        serialize(ints);

        
    }

    <E extends Serializable> void serialize(Collection<E> collection) {
        System.out.println("text");
    }
}
