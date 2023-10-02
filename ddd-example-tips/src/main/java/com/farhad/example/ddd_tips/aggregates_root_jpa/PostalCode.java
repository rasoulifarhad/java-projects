package com.farhad.example.ddd_tips.aggregates_root_jpa;

import java.util.Objects;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public class PostalCode implements ValueObject {

    private final String postalCode;

    @JsonCreator
    public PostalCode(@NonNull String postalCode) {
        this.postalCode = Objects.requireNonNull(postalCode, "postalCode must not be null");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostalCode that = (PostalCode) o;
        return Objects.equals(postalCode, that.postalCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postalCode);
    }

    @Override
    @JsonValue
    public String toString() {
        return postalCode;
    }
}
