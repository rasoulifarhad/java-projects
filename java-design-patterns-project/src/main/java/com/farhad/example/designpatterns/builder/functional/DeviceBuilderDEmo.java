package com.farhad.example.designpatterns.builder.functional;

import java.time.ZonedDateTime;
import java.util.UUID;
import java.util.function.Consumer;
import lombok.Data;
import lombok.ToString;

public class DeviceBuilderDEmo {
    
    public static class Demo01 {

        @ToString
        public static class Device {
            private UUID deviceUuid;
            private String name;
            private UUID hardwareUuid;
            private ZonedDateTime created;

            public Device(Builder builder ) {
                this.deviceUuid = builder.getDeviceUuid();
                this.name = builder.getName();
                this.hardwareUuid = builder.getHardwareUuid();
                this.created = builder.getCreated();
            }

            @Data
            public static class Builder { 
                private final String name;
                private final UUID hardwareUuid;
                private ZonedDateTime created;
                private UUID deviceUuid;

                public Builder(final String name, final UUID hardwareUuid) {

                    this.name = name;
                    this.hardwareUuid = hardwareUuid;
                    deviceUuid = UUID.randomUUID();
                    created = ZonedDateTime.now();
                }

                public Builder with( Consumer<Builder> consumer) {
                    consumer.accept(this);
                    return this;
                }
                
                public Device build() {
                    return new Device(this);
                }
            }
        }

        public static void main(String[] args) {
            
            Device device = new Device.Builder("adevice", UUID.randomUUID())
                    .with(
                        $ ->  {
                            $.deviceUuid = UUID.randomUUID();
                            $.created = ZonedDateTime.now();
                        }
                    )
                    .build();
            System.out.println(device);
        }
    }

    static class Demo03 {

        @ToString
        static class Device {
            private UUID deviceUuid;
            private String name;
            private UUID hardwareUuid;
            private ZonedDateTime created;

            private Device(Builder builder ) {
                this.deviceUuid = builder.getDeviceUuid();
                this.name = builder.getName();
                this.hardwareUuid = builder.getHardwareUuid();
                this.created = builder.getCreated();
            }

            @Data
            static class Builder { 
                private final String name;
                private final UUID hardwareUuid;
                private ZonedDateTime created;
                private UUID deviceUuid;

                public Builder(final String name, final UUID hardwareUuid) {

                    this.name = name;
                    this.hardwareUuid = hardwareUuid;
                    deviceUuid = UUID.randomUUID();
                    created = ZonedDateTime.now();
                }

                public Builder deviceUuid( UUID deviceUuid) {
                    this.deviceUuid = deviceUuid;
                    return this;
                }
                
                public Builder created(ZonedDateTime created) {
                    this.created = created;
                    return this;
                }
                
                public Device build() {
                    return new Device(this);
                }
            }
        }

        public static void main(String[] args) {
            
            Device device = new Device.Builder("a device", UUID.randomUUID())
                                    .deviceUuid(UUID.randomUUID())
                                    .created(ZonedDateTime.now()) 
                                    .build();
            System.out.println(device);
        }
    }

    static class Demo04 {

        abstract static class Device {
            private final String name;
            private final UUID hardwareUuid;
            private final UUID deviceUuid;
            private final ZonedDateTime created;

            private Device(Builder<?> builder) {
                this.name = builder.name;
                this.hardwareUuid = builder.hardwareUuid;
                this.deviceUuid = builder.deviceUuid;
                this.created = builder.created;
            }

            @Data
            abstract static class Builder<T extends Builder> {
                private final String name;
                private final UUID hardwareUuid;
                private UUID deviceUuid;
                private ZonedDateTime created;

                public Builder(final String name, final UUID hardwareUuid) {
                    this.name = name;
                    this.hardwareUuid = hardwareUuid;
                    this.deviceUuid = UUID.randomUUID();
                    this.created = ZonedDateTime.now();
                }
                 
                public T deviceUuid(UUID deviceUuid) {
                    this.deviceUuid = deviceUuid;
                    return self();
                }

                public T created(ZonedDateTime created) {
                    this.created = created;
                    return self();
                }

                public abstract Device build();

                protected abstract T self();
            }
        }

        @Data
        static class Tracker extends Device {

            private final double lat;
            private final double lon;
            private int battery;

            Tracker(Builder builder) {
                super(builder);
                this.lat = builder.lat;
                this.lon = builder.lon;
                this.battery = builder.battery; 
            }

            public static class Builder extends Device.Builder<Builder> {

                private final double lat;
                private final double lon;
                private int battery;

                public Builder(final String name, final UUID hardwareUuid, final double lat, final double lon) {
                    super(name, hardwareUuid);
                    this.lat = lat;
                    this.lon = lon;
                    battery = 100;
                }

                public Builder battery(int battery) { 
                    this.battery = battery;
                    return this;
                }

                public Tracker build() {
                    return new Tracker(this);
                }

                @Override
                protected Builder self() {
                    return this;
                }

                
            }
        }

        public static void main(String[] args) {
            
            Tracker tracker = new Tracker.Builder("a tracker", UUID.randomUUID(), 14.1053D, 52.12345D).battery(80).build();

            System.out.println(tracker);

        }
    }

}
