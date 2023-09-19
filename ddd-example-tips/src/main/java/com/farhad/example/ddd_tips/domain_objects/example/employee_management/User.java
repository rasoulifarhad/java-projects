package com.farhad.example.ddd_tips.domain_objects.example.employee_management;

import java.util.Objects;
import java.util.UUID;

import com.farhad.example.ddd_tips.domain_objects.IdentifiableDomainObject;
import com.farhad.example.ddd_tips.domain_objects.example.employee_management.User.UserId;
import com.fasterxml.jackson.annotation.JsonCreator;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User implements IdentifiableDomainObject<UserId> {
    
    @EqualsAndHashCode.Include
    private final UserId userId;
    private final String firstName;
    private final String lastName; 

    @JsonCreator // We can deserialize the incoming JSON directly into an instance of this class.
    public User(String userId, String firstName, String lastName) {
        Objects.requireNonNull(userId);
        this.userId = new UserId(userId); 
        this.firstName = Objects.requireNonNull(firstName);
        this.lastName = Objects.requireNonNull(lastName);
    }

    public String getFullName() {
        return String.format("%s %s", firstName, lastName);
    }

    @Value
    @RequiredArgsConstructor
    static class UserId {

        public static UserId createRandomUnique() {
            return new UserId(UUID.randomUUID().toString());
        }

        @NonNull
        private final String id; 
    }
}
