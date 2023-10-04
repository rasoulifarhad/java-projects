package com.farhad.example.ddd_tips.education_domain.domain.model;

import java.util.Set;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CourseSubscription implements AggregateRoot {

    @EqualsAndHashCode.Include
    private CourseSubscriptionId courseId;

    private String courseName;

    private int capacity;
    
    Set<Subscription> subscriptions;

    @Override
    public CourseSubscriptionId id() {
        return courseId;
    }
}
