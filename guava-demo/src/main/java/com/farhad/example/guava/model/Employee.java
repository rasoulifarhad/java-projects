package com.farhad.example.guava.model;

import lombok.Data;

@Data
public class Employee {
    private String name;
    private Integer age;
    private Job job;

    public boolean equals(Object object) {
        if(!(object instanceof Employee)) {
            return false;
        }
        Employee that = (Employee)object;
        return (name == that.getName() || (name != null && name.equals(that.getName()) ))
                && (age == that.getAge() || (age != null && age.equals(that.getAge())))
                && job == that.getJob();
    }

    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (job != null ? job.hashCode() : 0);
        return result;
    }
}
