package com.farhad.example.work_effevtively_with_legacy_code.sprout_class.demo2;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public interface DatabaseStore {

    List<Result> queryResults(LocalDate beginDate, LocalDate endDate);

    public class FakeDatabaseStore implements DatabaseStore {

        @Override
        public List<Result> queryResults(LocalDate beginDate, LocalDate endDate) {
            return Arrays.asList(
                new Result("Department #1", "Manager #1", 60, 40),
                new Result("Department #2", "Manager #2", 50, 30),
                new Result("Department #3", "Manager #3", 20, 60),
                new Result("Department #4", "Manager #4", 70, 80),
                new Result("Department #5", "Manager #5", 90, 10)
            );
        }

    }
}
