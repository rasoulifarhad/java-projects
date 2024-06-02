package com.farhad.example.work_effevtively_with_legacy_code.sprout_class.demo1;

import java.time.LocalDate;

import com.farhad.example.work_effevtively_with_legacy_code.sprout_class.demo1.DatabaseStore.FakeDatabaseStore;

public class App {

    public static void main(String[] args) {
        DatabaseStore database = new FakeDatabaseStore();
        QuarterlyReportGenerator reportGenerator = 
            new QuarterlyReportGenerator(database, 
                LocalDate.now().minusDays(10), 
                LocalDate.now());

        System.out.println(reportGenerator.generate());
    }
}
