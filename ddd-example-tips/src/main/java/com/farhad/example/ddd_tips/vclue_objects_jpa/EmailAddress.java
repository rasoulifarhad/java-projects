package com.farhad.example.ddd_tips.vclue_objects_jpa;

import javax.validation.constraints.NotNull;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class EmailAddress implements ValueObject {
    
    private final String email;

    public EmailAddress(@NotNull String email) {
        this.email = validate(email);
    }

    public static @NotNull String validate(@NotNull String email) {
        if(!isValid(email)) {
            throw new IllegalArgumentException("Invalid email: " + email);
        }
        return email;
    }

    private static boolean isValid(@NotNull String email) {
        return true;
    }

    @Override
    public @NotNull String toString() {
        return  email;
    }

    
    

}
