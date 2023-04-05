package com.farhad.example.jackson.sed;

import java.io.IOException;

import com.farhad.example.jackson.model.Car;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

/**
 * Jackson enables you to set a custom serializer on the ObjectMapper. This serializer is registered for a certain class, and will 
 * then be called whenever the ObjectMapper is asked to serialize a Car object. 
 */
public class CarSerializer extends StdSerializer<Car> {


    public CarSerializer(Class<Car> clazz) {
        super(clazz);
    }

    @Override
    public void serialize(Car car, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        gen.writeStringField("producer", car.getBrand());
        gen.writeNumberField("doorCount", car.getDoors());
        gen.writeEndObject();
    } 
    
    
}
