package com.farhad.example.ddd_tips.aggregates_root_jpa;

import java.util.Objects;
import java.util.UUID;

import javax.validation.constraints.NotNull;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public abstract class DomainObjectId implements ValueObject{

    @EqualsAndHashCode.Include
    private final String uuid;

    @JsonCreator
    public DomainObjectId(@NotNull String uuid) {
        this.uuid = Objects.requireNonNull(uuid);
    }

    @NotNull
    public static <ID extends DomainObjectId> ID randomId(@NonNull Class<ID> idClass) {
        Objects.requireNonNull(idClass);
        try {
            return idClass.getConstructor(String.class).newInstance(UUID.randomUUID().toString());
        } catch (Exception e) {
            throw new RuntimeException("Could not create new instance of " + idClass, e);
        }
    }

    @JsonValue
    @NonNull
    public String toUUID() {
        return uuid;
    }
    
    @Override
    public String toString() {
        return String.format("%s[%s]", getClass().getSimpleName(), uuid);
    }    
}
