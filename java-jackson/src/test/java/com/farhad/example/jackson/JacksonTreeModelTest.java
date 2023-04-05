package com.farhad.example.jackson;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.farhad.example.jackson.model.Car;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

/**
 * Jackson has a built-in tree model which can be used to represent a JSON object. 
 * 
 * Jackson's tree model is useful if you don't know how the JSON you will receive looks, or if you for some reason cannot (or just don't 
 * want to) create a class to represent it. The Jackson Tree Model is also useful if you need to manipulate the JSON before using or 
 * forwarding it. All of these situations can easily occur in a Data Streaming scenario.
 * 
 * The Jackson tree model is represented by the JsonNode class. You use the Jackson ObjectMapper to parse JSON into a JsonNode tree model, 
 * just like you would have done with your own class.
 * 
 * The JsonNode class lets you navigate the JSON as a Java object in a quite flexible and dynamic way.
 * 
 * Once you have parsed your JSON into a JsonNode (or a tree of JsonNode instances) you can navigate the JsonNode tree model.
 */
@Slf4j
public class JacksonTreeModelTest {
    

    @Test
    public void readJsonNodeTest() {

        String carJson ="{\"brand\" : \"Honda\", \"doors\" : 5 }";
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode jsonNode = mapper.readValue(carJson, JsonNode.class);
            log.info("JsonNode: {}", jsonNode);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            JsonNode anotherJsonNode = mapper.readTree(carJson);
            log.info("AnotherJsonNode: {}", anotherJsonNode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void jsonNodeNavigationTest() {

        String carJson =
                "{ \"brand\" : \"Honda\", \"doors\" : 5," +
                "  \"owners\" : [\"Sam\", \"Jack\", \"Jill\"]," +
                "  \"options\" : { \"color\" : \"black\" } }";
        ObjectMapper mapper = new ObjectMapper();

        try {

            JsonNode jsonNode = mapper.readValue(carJson, JsonNode.class);

            JsonNode brandNode = jsonNode.get("brand");
            String brand = brandNode.asText() ;
            log.info("Brand: {}", brand);

            JsonNode doorsNode = jsonNode.get("doors");
            int doors = doorsNode.asInt() ;
            log.info("Doors: {}", doors);

            JsonNode ownersNodeArray = jsonNode.get("owners");
            JsonNode samNode = ownersNodeArray.get(0);
            String sam = samNode.asText();
            log.info("Sam: {}", sam);

            JsonNode optionsChildNode = jsonNode.get("options");
            JsonNode colorNode = optionsChildNode.get("color");
            String color = colorNode.asText();
            log.info("Color: {}", color);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void convertCarToJsonNode() {

        Car car = new Car() ;
        car.setBrand("Honda");
        car.setDoors(5);

        ObjectMapper mapper = new ObjectMapper();

        JsonNode jsonNode =  mapper.valueToTree(car);

        log.info("JsonNode: {}", jsonNode);
    }

    @Test
    public void convertJsonNodeToVCar() throws JsonMappingException, JsonProcessingException{

        String carJson ="{\"brand\" : \"Honda\", \"doors\" : 5 }";

        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(carJson);

        Car car = mapper.treeToValue(jsonNode, Car.class);
        log.info("Car: {}", car);
    }   
}
