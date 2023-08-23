package com.farhad.example.designpatterns.anotherchainofresponsibility;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;
import lombok.Data;
import lombok.RequiredArgsConstructor;

public class RevisitedNotifierDemo {

    public static void main(String[] args) {
        
        UserProfile userProfile01 = new UserProfile(true, true, true);
        Stream.of(
            new GoogleWalletPassUpdateNotifier(),
            new EmailNotifier(),
            new SmsNotifier()
        )
        .filter(p -> p.test(userProfile01))
        .findFirst()
        .ifPresent(c -> c.accept(userProfile01));

        UserProfile userProfile02 = new UserProfile(false, true, true);
        Stream.of(
            new GoogleWalletPassUpdateNotifier(),
            new EmailNotifier(),
            new SmsNotifier()
        )
        .filter(p -> p.test(userProfile02))
        .findFirst()
        .ifPresent(c -> c.accept(userProfile02));

        UserProfile userProfile03 = new UserProfile(false, false, true);
        Stream.of(
            new GoogleWalletPassUpdateNotifier(),
            new EmailNotifier(),
            new SmsNotifier()
        )
        .filter(p -> p.test(userProfile03))
        .findFirst()
        .ifPresent(c -> c.accept(userProfile03));

        UserProfile userProfile04= new UserProfile(false, false, false);
        Stream.of(
            new GoogleWalletPassUpdateNotifier(),
            new EmailNotifier(),
            new SmsNotifier()
        )
        .filter(p -> p.test(userProfile04))
        .findFirst()
        .ifPresent(c -> c.accept(userProfile04));

        UserProfile userProfile = new UserProfile(false, false, true);
        Stream.of(
            new UserNotifier(UserProfile::isAllowsSms, p -> System.out.println("Sms sent."))
        )
        .filter(u -> u.predicate.test(userProfile))
        .findFirst()
        .ifPresent(u -> u.consumer.accept(userProfile));
    }

    @RequiredArgsConstructor
    @Data
    static class UserNotifier {
        private final Predicate<UserProfile> predicate;
        private final Consumer<UserProfile> consumer;
    }    
    static class GoogleWalletPassUpdateNotifier implements Predicate<UserProfile>, Consumer<UserProfile> {

        @Override
        public void accept(UserProfile profile) {
            System.out.println("Google wallet pass updated.");
        }

        @Override
        public boolean test(UserProfile profile) {
            return profile.isHasGooleWalletPass();
        }
    }

    static class EmailNotifier implements Predicate<UserProfile>, Consumer<UserProfile> {

        @Override
        public void accept(UserProfile profile) {
            System.out.println("Email sent.");
        }

        @Override
        public boolean test(UserProfile profile) {
            return profile.isAllowsEmail();
        }
    }

    static class SmsNotifier implements Predicate<UserProfile>, Consumer<UserProfile> {

        @Override
        public void accept(UserProfile profile) {
            System.out.println("Sms sent.");
        }

        @Override
        public boolean test(UserProfile profile) {
            return profile.isAllowsSms();
        }
    }

    @RequiredArgsConstructor
    @Data
    static class UserProfile {
        private final boolean hasGooleWalletPass;
        private final boolean allowsEmail;
        private final boolean allowsSms;
    }
}
