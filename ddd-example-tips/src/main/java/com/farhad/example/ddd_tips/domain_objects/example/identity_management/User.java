package com.farhad.example.ddd_tips.domain_objects.example.identity_management;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

import com.farhad.example.ddd_tips.domain_objects.AggregateRoot;
import com.farhad.example.ddd_tips.domain_objects.example.identity_management.User.UserId;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.Value;

@Getter
@Setter
public class User extends AggregateRoot<UserId> {
    
    private String userName;
    private String firstName;
    private String lastName;
    private Instant validFrom;
    private Instant validTo;
    private boolean disabled;
    private Instant nextPasswordChange;
    private List<Password> passwordHistory;

    public User(UserId id) {
        super(id);
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
