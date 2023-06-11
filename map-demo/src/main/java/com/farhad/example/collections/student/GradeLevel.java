package com.farhad.example.collections.student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GradeLevel {
    private long id ;
    private String name;
    
    private static final GradeLevel DEFAULT_GRADE_LEVEL = findLevelByName("Freshman");
    public static List<String> names() {
        return ALL_GRADE_LEVELS.stream()
                                    .map(GradeLevel::getName)
                                    .collect(Collectors.toList());
    }

    public static GradeLevel findLevelByName(String name) {
        return ALL_GRADE_LEVELS.stream()
                                    .filter(g -> g.getName().equals(name))
                                    .findFirst()
                                    .get();
    }

    public static GradeLevel defaultLevel() {
        return DEFAULT_GRADE_LEVEL;
    }

    private static List<GradeLevel> ALL_GRADE_LEVELS = new ArrayList<>();

    static {
        ALL_GRADE_LEVELS.add(new GradeLevel(1L, "Freshman"));
        ALL_GRADE_LEVELS.add(new GradeLevel(2L, "Sophomore"));
        ALL_GRADE_LEVELS.add(new GradeLevel(3L, "Junior"));
        ALL_GRADE_LEVELS.add(new GradeLevel(4L, "Senior"));
        ALL_GRADE_LEVELS.add(new GradeLevel(5L, "Other"));
    }
}
