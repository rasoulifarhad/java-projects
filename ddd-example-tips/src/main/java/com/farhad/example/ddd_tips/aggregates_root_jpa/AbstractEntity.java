package com.farhad.example.ddd_tips.aggregates_root_jpa;

import static java.util.Objects.requireNonNull;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode( onlyExplicitlyIncluded = true)
@MappedSuperclass
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class AbstractEntity<ID extends DomainObjectId>  implements IdentifiableDomainObject<ID>{
     
    @Id
    @JsonProperty("id")
    @EqualsAndHashCode.Include
    private ID id;

    protected AbstractEntity(@NonNull AbstractEntity<ID> source) {
        requireNonNull(source);
        this.id = source.id;

    }

    protected AbstractEntity(@NonNull ID id) {
        this.id = requireNonNull(id);

    }

    @Override
    @Nullable
    public ID id() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("%s[%s]", getClass().getSimpleName(), id);
    }
}
