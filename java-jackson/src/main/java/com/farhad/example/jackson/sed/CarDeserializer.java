package com.farhad.example.jackson.sed;

import java.io.IOException;

import com.farhad.example.jackson.model.Car;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CarDeserializer extends StdDeserializer<Car>{

    

    public CarDeserializer(Class<?> clazz) {
        super(clazz);
    }

    @Override
    public Car deserialize(JsonParser parser, DeserializationContext ctxt) throws IOException, JacksonException {
        Car car = new Car() ;
        while (!parser.isClosed()) {

            JsonToken jsonToken = parser.nextToken();

            if( JsonToken.FIELD_NAME.equals(jsonToken)) {
                String fieldName = parser.getCurrentName();
                log.info("{}", fieldName);

                jsonToken = parser.nextToken() ;

                if("brand".equals(fieldName)) {
                    car.setBrand(parser.getValueAsString());
                } else if ("doors".equals(fieldName)) {
                    car.setDoors(parser.getValueAsInt());
                }
            }
        }
        return car;
    }
    
}
