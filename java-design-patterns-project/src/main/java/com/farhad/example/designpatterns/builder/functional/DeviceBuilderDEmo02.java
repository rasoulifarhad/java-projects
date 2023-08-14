package com.farhad.example.designpatterns.builder.functional;

import java.time.ZonedDateTime;
import java.util.UUID;
import lombok.Builder;
import lombok.ToString;
import lombok.Value;

public class DeviceBuilderDEmo02 {
    
    public static class Demo02 {

        @Builder
        @Value
        @ToString
        static class Device {

            private String name;
            private UUID hardwareUuid;
            @Builder.Default
            private UUID deviceUuid = UUID.randomUUID();
            @Builder.Default
            private ZonedDateTime created = ZonedDateTime.now();
        }

        public static void main(String[] args) {
            Device device = Device.builder()
                                .name("a device")
                                .hardwareUuid(UUID.randomUUID())
                                .build();
            System.out.println(device); 
        }
    }


}
