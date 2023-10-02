package com.farhad.example.ddd_tips.aggregates_root_jpa;

import java.io.Serializable;
import java.util.Optional;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Version;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.lang.Nullable;

@MappedSuperclass
public abstract class BaseEntity<Id extends Serializable> extends AbstractPersistable<Id> {
    @Version
    private Long version;

    public @NotNull Optional<Long> getVersion() {
        return Optional.ofNullable(version);
    }

    protected void setVersion(@Nullable Long version) {
        this.version = version;
    }

    
}
