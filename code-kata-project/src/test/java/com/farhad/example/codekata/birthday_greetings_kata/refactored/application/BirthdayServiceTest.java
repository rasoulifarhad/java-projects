package com.farhad.example.codekata.birthday_greetings_kata.refactored.application;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.farhad.example.codekata.birthday_greetings_kata.refactored.core.GreetingMessage;
import com.farhad.example.codekata.birthday_greetings_kata.refactored.infrastructure.repository.FileEmployeeRepository;

public class BirthdayServiceTest {
    
    private static final String EMPLOYEES_FILE_PATH = "src/test/resources/employee_data.txt";    

    private BirthdayService birthdayService;
    private ListMessageService messageService ;
    @BeforeEach
    public void setup() {
        messageService = new ListMessageService();
        birthdayService = new BirthdayService(
            new FileEmployeeRepository(EMPLOYEES_FILE_PATH), 
            messageService);
    }

    @Test 
    public void baseScenario() {
        birthdayService.sendGreetings(LocalDate.of(2008, 10, 8));
        assertThat(messageService.getSentGreetingMessages().size()).isEqualTo(1);
        GreetingMessage message = messageService.getSentGreetingMessages().get(0);
        assertEquals("Happy Birthday, dear John!", message.text());
        assertEquals("Happy Birthday!", message.subject());
        assertEquals("john.doe@foobar.com", message.to());        
    }
}
