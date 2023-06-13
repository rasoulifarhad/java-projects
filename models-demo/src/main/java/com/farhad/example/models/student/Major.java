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
public class Major {
    // @EqualsAndHashCode.Exclude
    private long id ;
    private String name;

    public static Map<String,Boolean> makeMajorMap(List<String> majors) {
        return ALL_MAJORS.stream()
                            .collect(Collectors.toMap(Major::getName, m -> majors.contains(m.getName())));
    }
    
    public static Major findMajorByName(String name) {
        return  ALL_MAJORS.stream()
                                    .filter(m -> m.getName().equals(name) )
                                    .findFirst().get();
    }

    public static List<String> names(List<Major> majors) {
        return majors.stream()
                        .map(m -> m.getName() )
                        .collect(Collectors.toList());
    }


    private static List<Major> ALL_MAJORS = new ArrayList<>();
    static {
        ALL_MAJORS.add(new Major(1L, "Computer Science"));
                ALL_MAJORS.add(new Major(1L, "Chemistry"));
                ALL_MAJORS.add(new Major(2L, "Biology"));
                ALL_MAJORS.add(new Major(3L, "Physics"));
                ALL_MAJORS.add(new Major(4L, "Mathematics"));
    }

}
