package com.farhad.example.jackson;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

import com.farhad.example.jackson.annotation.PersonAnySetter;
import com.farhad.example.jackson.annotation.PersonIgnore;
import com.farhad.example.jackson.annotation.PersonIgnoreProperties;
import com.farhad.example.jackson.annotation.PersonIgnoreType;
import com.farhad.example.jackson.annotation.PersonJsonAnyGetter;
import com.farhad.example.jackson.annotation.PersonJsonCreator;
import com.farhad.example.jackson.annotation.PersonJsonDeserialize;
import com.farhad.example.jackson.annotation.PersonJsonGetter;
import com.farhad.example.jackson.annotation.PersonJsonInclude;
import com.farhad.example.jackson.annotation.PersonJsonInject;
import com.farhad.example.jackson.annotation.PersonJsonPropertyOrder;
import com.farhad.example.jackson.annotation.PersonJsonRawValue;
import com.farhad.example.jackson.annotation.PersonJsonSerialize;
import com.farhad.example.jackson.annotation.PersonJsonSetter;
import com.farhad.example.jackson.annotation.PersonJsonValue;
import com.farhad.example.jackson.annotation.PersonWithType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ReadWriteAnnotationsTest {
    

    @Test
    public void jsonIgnoreReadAnnotationTest() throws JsonMappingException, JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        String personJson = "{\"personId\" : 5, \"name\" : \"farhad\" }" ;

        PersonIgnore personIgnore =  mapper.readValue(personJson, PersonIgnore.class);
        log.info("{}",personIgnore);
    }

    @Test
    public void jsonIgnoreWriteAnnotationTest() throws JsonMappingException, JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        PersonIgnore personIgnore = new PersonIgnore(10L,"farhad");
        
        String prsonIgnoreJson = mapper.writeValueAsString(personIgnore);

        log.info("{}",prsonIgnoreJson);
    }

    @Test
    public void jsonIgnorePropertiesReadAnnotationTest() throws JsonMappingException, JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        String personJson = "{\"personId\" : 5, \"firstName\" : \"farhad\", \"lastName\" : \"rasouli\" }" ;

        PersonIgnoreProperties personIgnoreProperties =  mapper.readValue(personJson, PersonIgnoreProperties.class);
        log.info("{}",personIgnoreProperties);
    }

    @Test
    public void jsonPersonWithTypeReadAnnotationTest() throws JsonMappingException, JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        String personJson = "{\"personId\" : 5, \"name\" : \"farhad\", \"address\" : {\"streetName\" : \"streetName\", \"city\" : \"city\",  \"country\" : \"country\"} }" ;

        PersonWithType personWithType = mapper.readValue(personJson, PersonWithType.class);
        log.info("{}", personWithType);
    }

    @Test
    public void jsonIgnoreTypeReadAnnotationTest() throws JsonMappingException, JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        String personJson = "{\"personId\" : 5, \"name\" : \"farhad\", \"address\" : {\"streetName\" : \"streetName\", \"city\" : \"city\",  \"country\" : \"country\"} }" ;

        PersonIgnoreType personIgnoreType = mapper.readValue(personJson, PersonIgnoreType.class);
        log.info("{}", personIgnoreType);
    }

    @Test
    public void jsonSetterAnnotationTest() throws JsonMappingException, JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        String personJson = "{\"id\" : 5, \"name\" : \"farhad\" }" ;

        PersonJsonSetter personJsonSetter = mapper.readValue(personJson, PersonJsonSetter.class);
        log.info("{}", personJsonSetter);
    }

    @Test
    public void jsonAnySetterAnnotationTest() throws JsonMappingException, JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        String personJson = "{\"personId\" : 5, \"name\" : \"farhad\", \"age\" : 45, \"desc\" : \"farhad desc\" }" ;

        PersonAnySetter personAnySetter = mapper.readValue(personJson, PersonAnySetter.class);
        log.info("{}", personAnySetter);
    }

    @Test
    public void jsonCreatorAnnotationTest() throws JsonMappingException, JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        String personJson = "{\"id\" : 5, \"name\" : \"farhad\"}" ;

        PersonJsonCreator personJsonCreator = mapper.readValue(personJson, PersonJsonCreator.class);
        log.info("{}", personJsonCreator);
    }

    @Test
    public void jsonInjectAnnotationTest() throws JsonMappingException, JsonProcessingException {

        InjectableValues injectableValues = new InjectableValues.Std().addValue(String.class, "MY_SOURCE");
        ObjectMapper mapper = new ObjectMapper();
        ObjectReader objectReader =  mapper.reader(injectableValues).forType(PersonJsonInject.class);
        String persdonJson = "{\"id\" : 5, \"name\" : \"farhad\"}" ;

        PersonJsonInject personJsonInject =  objectReader.readValue(persdonJson);
        log.info("{}", personJsonInject);
    }

    @Test
    public void jsonDeserializerAnnotationTest() throws JsonMappingException, JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper() ;
        ObjectReader objectReader = mapper.readerFor(PersonJsonDeserialize.class);
        String persdonJson = "{\"id\" : 5, \"name\" : \"farhad\", \"enabled\" : 0}" ;
        String persdonJson2 = "{\"id\" : 5, \"name\" : \"farhad\", \"enabled\" : 1}" ;

        PersonJsonDeserialize personJsonDeserialize = objectReader.readValue(persdonJson);
        log.info("{}", personJsonDeserialize);
        PersonJsonDeserialize personJsonDeserialize2 = objectReader.readValue(persdonJson2);
        log.info("{}", personJsonDeserialize2);
    }

    @Test
    public void jsonIncludeWriteAnnotationTest() throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        PersonJsonInclude personJsonInclude = new PersonJsonInclude(10, "");

        String personJson = mapper.writeValueAsString(personJsonInclude);
        log.info("{}", personJson);
    }

    @Test
    public void jsonGetterSetterWriteAnnotationTest() throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        PersonJsonGetter personJsonGetter = new PersonJsonGetter(10, "farhad");

        String personJson = mapper.writeValueAsString(personJsonGetter);
        log.info("{}", personJson);
    }

    @Test
    public void jsonAnyGetterWriteAnnotationTest() throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        PersonJsonAnyGetter personJsonAnyGetter = new PersonJsonAnyGetter(10, "farhad", new HashMap<String,Object>()
        {{ 
            put("age", Integer.valueOf(45)); 
            put("test", "test"); 
        }});

        String personJson = mapper.writeValueAsString(personJsonAnyGetter);
        log.info("{}", personJson);
    }

    @Test
    public void jsonPropertyOrderWriteAnnotationTest() throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        PersonJsonPropertyOrder personJsonPropertyOrder = new PersonJsonPropertyOrder(10, "farhad");

        String personJson = mapper.writeValueAsString(personJsonPropertyOrder);
        log.info("{}", personJson);
 
    }

    @Test
    public void jsonRawValueWriteAnnotationTest() throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        PersonJsonRawValue personJsonRawValue = new PersonJsonRawValue(10, 
                                                                "farhad", 
                                                                 "{ \"street\" : \"Wall Street\", \"no\":1}",
                                                                 "{ \"street\" : \"Wall Street\", \"no\":1}");

        String personJson = mapper.writeValueAsString(personJsonRawValue);
        log.info("{}", personJson);

        personJsonRawValue = new PersonJsonRawValue(10, 
                                                "farhad", 
                                                "ttttt",
                                                "ttttt");
        personJson = mapper.writeValueAsString(personJsonRawValue);
        log.info("{}", personJson);
    }

    @Test
    public void jsonValueWriteAnnotationTest() throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper() ;

        PersonJsonValue personJsonValue = new PersonJsonValue(10, "farhad");

        String personJson = mapper.writeValueAsString(personJsonValue);
        log.info("{}", personJson);
    }

    @Test
    public void jsonSerializerWriteAnnotationTest() throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper() ;

        PersonJsonSerialize PersonJsonSerialize = new PersonJsonSerialize(10, "true-farhad", true);
        String personJson = mapper.writeValueAsString(PersonJsonSerialize);
        log.info("{}", personJson);

        PersonJsonSerialize = new PersonJsonSerialize(10, "false-farhad", false);
        personJson = mapper.writeValueAsString(PersonJsonSerialize);
        log.info("{}", personJson);

    }
}
