package com.farhad.example.jackson;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.farhad.example.jackson.model.Car;
import com.farhad.example.jackson.sed.CarDeserializer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.fasterxml.jackson.databind.module.SimpleModule;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ReadObjectFromJsonStringTest {
    
    @Test
    public void readCarFromJsonStringTest() {

        ObjectMapper mapper = new ObjectMapper();
        String carJson ="{\"brand\" : \"Honda\", \"doors\" : 5 }";
        try {
            Car car = mapper.readValue(carJson, Car.class);

            log.info("{}", car);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void readCarFromJsonReaderTest() throws StreamReadException, DatabindException, IOException {
;
        ObjectMapper mapper = new ObjectMapper();
        String carJson ="{\"brand\" : \"Honda\", \"doors\" : 5 }";

        Reader reader = new StringReader(carJson);

        Car car = mapper.readValue(reader, Car.class);
        log.info("{}", car);
        
    }

    @Test
    public void readCarFromInputStreamTest() throws StreamReadException, DatabindException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        
        // InputStream inputStream = new FileInputStream("data/car.json");
        Car car = mapper.readValue(getClass().getClassLoader().getResourceAsStream("data/car.json"), Car.class);

        log.info("{}", car);
    }

    @Test
    public void readCarFromByteArrayTest() throws StreamReadException, DatabindException, IOException {

        ObjectMapper mapper = new ObjectMapper();
        String carJson ="{\"brand\" : \"Honda\", \"doors\" : 5 }";

        byte[] bytes = carJson.getBytes("UTF-8");
        Car car = mapper.readValue(bytes, Car.class);
        log.info("{}", car);
    }

    @Test 
    public void readCarFromJsonArrayStringTest() throws JsonMappingException, JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();

        String jsonArray = "[{\"brand\" : \"Honda\", \"doors\" : 5 },{\"brand\" : \"BMW\", \"doors\" : 4 }]";

        Car[] cars = mapper.readValue(jsonArray, Car[].class);

        for (Car car : cars) {
            log.info("{}",car);
        }
    }
    
    @Test 
    public void readMapFromJsonStringTest() throws JsonMappingException, JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString ="{\"brand\" : \"Honda\", \"doors\" : 5 }";

        Map<String,Object> jsonMap = mapper.readValue(jsonString, new TypeReference<Map<String,Object>>() {});
        log.info("{}",jsonMap);
    }

    @Test
    public void readCarFromJsonStringWhenUnknownJsonFieldsThenThrowExceptionTest() throws JsonMappingException, JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        String carJson ="{\"brand\" : \"Honda\", \"doors\" : 5, \"dontExistField\" : \"throwException\" }";

        Exception exception = assertThrows(UnrecognizedPropertyException.class,() -> mapper.readValue(carJson, Car.class));
        log.error("{}", exception.getMessage());
    }

    @Test
    public void readCarFromJsonStringWhenUnknownJsonFieldsThenIgnoreThatTest() throws JsonMappingException, JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        String carJson ="{\"brand\" : \"Honda\", \"doors\" : 5, \"dontExistField\" : \"throwException\" }";
        Car car = mapper.readValue(carJson, Car.class);

        log.info("{}", car);
    }

    @Test
    public void readCarFromJsonStringWhenValueOfPrimitiveTypesFieldIsNullThenFailThatTest() throws JsonMappingException, JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, true);
        
        String carJson ="{\"brand\" : \"Honda\", \"doors\" : null}";
        Exception exception = assertThrows(MismatchedInputException.class, () -> mapper.readValue(carJson, Car.class));

        log.error("{}", exception.getMessage());
    }

    @Test
    public void carDeserializerTest() throws JsonMappingException, JsonProcessingException {

        String carJson ="{\"brand\" : \"Honda\", \"doors\" : 5 }";

        SimpleModule module = new SimpleModule("CarDeserializer", new Version(1, 0, 0, null, null, null));
        module.addDeserializer(Car.class, new CarDeserializer(Car.class));

        ObjectMapper  mapper = new ObjectMapper() ;
        mapper.registerModule(module);

        Car car = mapper.readValue(carJson, Car.class);

        log.info("{}", car);

    }

}
