package com.farhad.example.models.student;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GradePointAverage {
    private long id;
    private String name;

    private static final GradePointAverage DEFAULT_GRADE_POINT_AVERAGE = findGPAByName("4.0");

    public static Map<String,Boolean> makeGPAMap(String gpaName) {
        return ALL_GRADE_POINT_AVERAGE.stream()
                                        .collect(Collectors.toMap(GradePointAverage::getName, g -> gpaName.equals(g.getName())));
    }
    public static List<String> gpaRanges() {
        return ALL_GRADE_POINT_AVERAGE.stream()
                                        .map(GradePointAverage::getName)
                                        .collect(Collectors.toList());
    }

    public static GradePointAverage findGPAByName(String name) {
        return ALL_GRADE_POINT_AVERAGE.stream()
                                        .filter(gpa -> name.equals(gpa.getName()))
                                        .findFirst()
                                        .get();
    }

    public static GradePointAverage defaultGPA() {
        return DEFAULT_GRADE_POINT_AVERAGE;
    }

    private static List<GradePointAverage> ALL_GRADE_POINT_AVERAGE = new ArrayList<>();

    static {
        ALL_GRADE_POINT_AVERAGE.add(new GradePointAverage(1L, "4.0"));
        ALL_GRADE_POINT_AVERAGE.add(new GradePointAverage(2L, "3.0 - 3.9"));
        ALL_GRADE_POINT_AVERAGE.add(new GradePointAverage(3L, "2.0 - 2.9"));
        ALL_GRADE_POINT_AVERAGE.add(new GradePointAverage(4L, "1.0 - 1.9"));
    } 
}
