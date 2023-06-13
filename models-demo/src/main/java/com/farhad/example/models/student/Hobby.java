package com.farhad.example.models.student;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
// @EqualsAndHashCode
public class Hobby {
    
    private long id ;
    private String name;

    public static Map<String, Boolean> MakeHobbyMap(List<String> hobbies) {
        return ALL_HOBBIES.stream()
                        .collect(Collectors.toMap(Hobby::getName, h -> hobbies.contains(h.getName()) ));
    }
    public static Hobby findHobbyByName(String name) {
        return ALL_HOBBIES.stream()
                            .filter(h -> h.getName().equals(name))
                            .findFirst().get();
    }

    public static List<String> names(List<Hobby> hobbies) {
        return hobbies.stream()
                        .map(h -> h.getName() )
                        .collect(Collectors.toList());
    }
    
    private static List<Hobby> ALL_HOBBIES = new ArrayList<Hobby>();

    static {
        ALL_HOBBIES.add(new Hobby(1L, "Surfing"));
        ALL_HOBBIES.add(new Hobby(2L, "Biking"));
        ALL_HOBBIES.add(new Hobby(3L, "Paddling"));
        ALL_HOBBIES.add(new Hobby(4L, "Running"));
    }
}
