package com.farhad.example.guava.model;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private String name;
    private Integer age;
    private Job job;

    public boolean equals(Object object) {
        if(!(object instanceof Employee)) {
            return false;
        }
        Employee that = (Employee)object;
        // return (name == that.getName() || (name != null && name.equals(that.getName()) ))
        //         && (age == that.getAge() || (age != null && age.equals(that.getAge())))
        //         && job == that.getJob();
        return Objects.equal(name, that.getName())
            && Objects.equal(age, that.getAge())
            && job == that.getJob();
    }

    public int hashCode() {
        // int result = name != null ? name.hashCode() : 0;
        // result = 31 * result + (age != null ? age.hashCode() : 0);
        // result = 31 * result + (job != null ? job.hashCode() : 0);
        // return result;
        return Objects.hashCode(name, age, job);
    }

    public String toString() {
        // StringBuilder sb = new StringBuilder();
        // sb.append(Employee.class.getSimpleName());
        // sb.append("{name=").append(name);
        // sb.append(", age=").append(age);
        // sb.append(", job=").append(job);
        // sb.append("}");
        // return sb.toString();
        return MoreObjects.toStringHelper(this)
                .add("name", name)
                .add("age", age)
                .add("job", job)
                .toString();
    }

    public int compareTo(Employee other) {
        int result = name.compareTo(other.getName());
        if(result !=0) {
            return result;
        }
        result = age.compareTo(other.getAge());
        if (result != 0 ) {
            return result;
        }
        return job.compareTo(other.getJob());
    }
}
