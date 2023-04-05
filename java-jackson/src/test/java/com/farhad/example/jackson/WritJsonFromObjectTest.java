package com.farhad.example.jackson;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.farhad.example.jackson.model.Car;
import com.farhad.example.jackson.model.Transaction;
import com.farhad.example.jackson.sed.CarSerializer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import lombok.extern.slf4j.Slf4j;

/**
 * The Jackson ObjectMapper can also be used to generate JSON from an object. You do so using the one of the methods:
 * 
 *  - writeValue()
 *  - writeValueAsString()
 *  - writeValueAsBytes()
 * 
 */
@Slf4j
public class WritJsonFromObjectTest {
    

    @Test
    public void writeJsonToStringFromCarObjectTest() throws FileNotFoundException, IOException {
        ObjectMapper mapper = new ObjectMapper();

        Car car = new Car();
        car.setBrand("Honda");
        car.setDoors(5);

        String carJson = mapper.writeValueAsString(car);
        mapper.writeValue(new FileOutputStream("data/output_1.json"), car);

        log.info("{}", carJson);
    }

    @Test
    public void writeJsonToFileFromCarObjectTest() throws FileNotFoundException, IOException {
        ObjectMapper mapper = new ObjectMapper();

        Car car = new Car();
        car.setBrand("Honda");
        car.setDoors(5);

        mapper.writeValue(new FileOutputStream("data/output_1.json"), car);

        List<String> lines = Files.readAllLines(Paths.get("data/output_1.json"));

        log.info("{}", lines);

    }

    @Test
    public void customCarSeriaklizerTest() throws JsonProcessingException {
        
        CarSerializer carSerializer = new CarSerializer(Car.class);
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule("CarSerializer", new Version(1, 0, 0, null, null, null));
        module.addSerializer(Car.class, carSerializer);

        mapper.registerModule(module);

        Car car = new Car();
        car.setBrand("Handa");
        car.setDoors(3);

        String carJson = mapper.writeValueAsString(car);

        log.info("{}", carJson);

    }

    @Test
    public void dateAsLongInTransactionTest() throws JsonProcessingException {
        Transaction transaction = new Transaction("credit", new Date());

        ObjectMapper mapper = new ObjectMapper();
        String transactionJson = mapper.writeValueAsString(transaction);

        log.info("{}", transactionJson);
    }

    @Test
    public void dateAsStringInTransactionTest() throws JsonProcessingException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Transaction transaction = new Transaction("credit", new Date());

        ObjectMapper mapper = new ObjectMapper();
        mapper.setDateFormat(simpleDateFormat);
        String transactionJson = mapper.writeValueAsString(transaction);

        log.info("{}", transactionJson);

        
    }

}
