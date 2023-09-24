package com.farhad.example.property;

import static java.util.Objects.requireNonNull;

import java.util.HashMap;
import java.util.Map;

public class Character implements Prototype {

    public enum Type {
        WARRIOR, MAGE, ROUGE
    }

    private final Prototype prototype;
    private Map<Stats, Integer> propeties = new HashMap<>();

    private String name;
    private Type type;

    

    public Character() {
        prototype = new Prototype() { // Null-value object

            @Override
            public Integer get(Stats stat) { return null; }

            @Override
            public boolean has(Stats stat) { return false; }

            @Override
            public void set(Stats stat, Integer value) {}

            @Override
            public void remove(Stats stat) {}
        };
    }

    

    public Character(Type type, Prototype prototype) {
        this.type = type;
        this.prototype = prototype;
    }

    

    public Character(String name, Character prototype) {
        this.name = name;
        this.type = prototype.type;
        this.prototype = prototype;
    }

    public String name() {
        return name;
    }

    public Type type() {
        return type;
    }
    @Override
    public Integer get(Stats stat) {
        requireNonNull(stat);
        return propeties.containsKey(stat) ? propeties.get(stat) : prototype.get(stat);
    }

    @Override
    public boolean has(Stats stat) {
        return get(stat) != null;
    }

    @Override
    public void set(Stats stat, Integer value) {
        requireNonNull(stat);
        requireNonNull(value);
        propeties.put(stat, value);
    }

    @Override
    public void remove(Stats stat) {
        requireNonNull(stat);
        propeties.put(stat, null);
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (name != null) {
            sb.append("Player: ").append(name).append('\n');
        }
        if (type != null) {
            sb.append("Character type: ").append(type.name()).append('\n');
        }
        sb.append("Stats:\n");
        for (Stats stat : Stats.values()) {
            Integer value = this.get(stat);
            if(value == null) {
                continue;
            }
            sb.append(" - ").append(stat.name()).append(":").append(value).append('\n');
        }
        return sb.toString();
    }
    
    
}
