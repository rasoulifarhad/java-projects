package com.farhad.example.stream.basic;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.apache.commons.lang3.Validate;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

public class JacksonStreamDemo {
    
    public static class User {

        private final long id;
        private final String name;

        @JsonCreator
        public User(@JsonProperty("id") final long id, @JsonProperty("name") final String name) {
            Validate.inclusiveBetween(1, 20, id, "Id must be  between 1 and 20 . was: " + id);
            this.id = id;
            this.name = Validate.notBlank(name).trim();
        }

        public long id() {
            return id;
        }

        public String name() {
            return name;
        }
    }

    public static class Support {
        private final static ObjectReader OBJECT_READER = new ObjectMapper().readerFor(User.class);

        public static Stream<String> jsonData() {
            return IntStream.rangeClosed(1,20)
                        .mapToObj(Support::item);
        }

        public static Stream<String> badJsonData() {
            final List<Integer> integers = IntStream.rangeClosed(1, 20).boxed().collect(Collectors.toList());
            integers.set(12, 21);
            return integers.stream().map(Support::item);
        }

        public static User parseJson(final String json) {
            try {
                final User user = OBJECT_READER.readValue(json);
                System.out.println("Parsed user with id: " + user.id());
                return user;
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        }

        private static String item(final int id) {
            return "{\"id\": \"" +id +"\", \"name\": \"item-" + id + "\"}";
        }

        public static void sendCouponTo(final List<User> users) {
            System.out.println("15%-off coupon send to " + users.size() + " users!");
        }

        public static void trackError(final Exception e) {
            System.out.println("ERROR:  Problem parsing user: " + e.getCause().getCause().getMessage() );
        }

        
    }
}
