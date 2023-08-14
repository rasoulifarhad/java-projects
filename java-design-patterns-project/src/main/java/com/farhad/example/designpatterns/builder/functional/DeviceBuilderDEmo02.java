package com.farhad.example.designpatterns.builder.functional;

import java.time.ZonedDateTime;
import java.util.UUID;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.Value;
import lombok.experimental.SuperBuilder;

public class DeviceBuilderDEmo02 {
    
    public static class Demo01 {

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

    static class Demo02 {


        @SuperBuilder
        @Getter
        @ToString
        abstract static class Device {

            private final String name;
            private final UUID hardwareUuid;
            @Builder.Default
            private final UUID deviceUuid = UUID.randomUUID();
            @Builder.Default
            private final ZonedDateTime created = ZonedDateTime.now();
        }

        @Value
        @SuperBuilder
        @EqualsAndHashCode(callSuper = true)
        static class Tracker extends Device {

            double lat;
            double lon;
            int battery;
        }

        public static void main(String[] args) {

            Tracker tracker = 
                Tracker.builder()
                            .name("a tracker")
                            .hardwareUuid(UUID.randomUUID())
                            .lat(13.00000)
                            .lon(52.00000)
                            .battery(80)
                            .build();
            System.out.println(tracker);
        }
    }


}
