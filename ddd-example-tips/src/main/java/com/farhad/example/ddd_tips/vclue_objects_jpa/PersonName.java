package com.farhad.example.ddd_tips.vclue_objects_jpa;

import static java.util.Objects.requireNonNull;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@EqualsAndHashCode
public class PersonName implements ValueObject {
    

    private String firstName;
    private String middleName;
    private String lastName;
    
    public PersonName(@NotNull String firstName, @NotNull String middleName, @NotNull String lastName) {
        this.firstName = requireNonNull(firstName);
        this.middleName = requireNonNull(middleName);
        this.lastName = requireNonNull(lastName);
    }

    public PersonName(@NotNull String firstName, @NotNull String lastName) {
        this(firstName, "", lastName);
    }

    

    

}
