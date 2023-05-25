package com.farhad.example.collections.map;

import java.util.HashMap;
import java.util.Map;

import com.farhad.example.collections.map.InitializeMapDemo.InitializeWithLombokAndEnumDemo.PropertiesDemo.Properties;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.MapType;

import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InitializeMapDemo {
    
    static class InitializeWithLombokAndJacksonDemo {

        public static void main(String[] args) {
            ObjectMapper mapper = new ObjectMapper();

            MapKeys mapKeys =  MapKeys.builder()
                                            .prop1("value1")
                                            .prop2("value2")
                                            .prop3(new Long(1))
                                      .build();      
            MapType mapType= mapper.getTypeFactory().constructMapType(Map.class, String.class, Object.class);
            Map<String,Object> map =  mapper.convertValue(mapKeys, mapType);
            log.info("Map: {}", map);

            mapKeys =  MapKeys.builder()
                                .prop1("Another value1")
                                .prop2("Another value2")
                                .prop3(new Long(10))
                              .build();
            map = mapper.convertValue( mapKeys, new TypeReference<Map<String,Object>>() {} );
            log.info("Map: {}", map);
        }

        @Builder
        @Getter
        static class MapKeys {

            private String prop1;
            private String prop2;
            private Long   prop3;
        }
    }

    static class InitializeWithLombokAndEnumDemo {
        public static void main(String[] args) {
            Map<String,String> initializedMap = 
                                            PropertiesDemo
                                                .builder()
                                                    .property(Properties.prop1, "value1")
                                                    .property(Properties.prop2, "value2")
                                                    .property(Properties.prop3, "value3")
                                                .build()
                                                .get();
            log.info("Map: {}", initializedMap);
        }

        @Builder
        public static class PropertiesDemo {
            enum Properties {
                prop1,
                prop2,
                prop3
            }
                
            private @Singular("property") Map<Properties,String> properties;

            public Map<String,String> get() {
                Map<String,String> map = new HashMap<>();
                this.properties
                        .forEach((k, v) -> map.put(k.toString(), v));
                return map;
            }
        }
    }
}
