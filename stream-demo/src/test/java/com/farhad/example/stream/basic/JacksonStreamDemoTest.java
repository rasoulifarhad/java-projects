package com.farhad.example.stream.basic;

import static com.farhad.example.stream.basic.JacksonStreamDemo.Support.badJsonData;
import static com.farhad.example.stream.basic.JacksonStreamDemo.Support.jsonData;
import static com.farhad.example.stream.basic.JacksonStreamDemo.Support.parseJson;
import static com.farhad.example.stream.basic.JacksonStreamDemo.Support.sendCouponTo;
import static com.farhad.example.stream.basic.JacksonStreamDemo.Support.trackError;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import com.farhad.example.stream.basic.JacksonStreamDemo.Support;
import com.farhad.example.stream.basic.JacksonStreamDemo.User;

public class JacksonStreamDemoTest {

    @Test
    public void testSendCouponTo() {
        final Stream<String>  jsonDataStream = jsonData();
        final List<User> users = jsonDataStream.map(Support::parseJson).collect(Collectors.toList());
        sendCouponTo(users);
    }

    @Test
    public void testSendCouponToBadJson() {
        try {
            final Stream<String>  jsonDataStream = badJsonData();
            final List<User> users = jsonDataStream.map(Support::parseJson).collect(Collectors.toList());
            sendCouponTo(users);
        } catch (Exception e) {
            trackError(e);
            System.out.println("No coupon sended!");
        }
    }

    @Test
    public void testSendCouponToBadJsonTryParse() {
        final List<User> users = badJsonData().flatMap(this::tryParse).collect(Collectors.toList());
        sendCouponTo(users);
    }

    Stream<User> tryParse(final String json) {
        try {
            return Stream.of(parseJson(json));
        } catch (Exception e) {
            trackError(e);
            return Stream.empty();
        }
    }

    @Test
    public void testSendCouponToBadJsonTryParseOptional() {
        final List<User> users = badJsonData().map(this::tryParseOptional)
                                                .flatMap(this::stream)
                                                .collect(Collectors.toList());
        sendCouponTo(users);
        
    }
            
    Optional<User> tryParseOptional(final String json) {
        try {
            return Optional.of(parseJson(json));
        } catch (Exception e) {
            trackError(e);
            return Optional.empty();
        }
    } 

    <T> Stream<T> stream(final Optional<T> optional) {
        return optional.map(Stream::of).orElseGet(Stream::empty);
    }

}
