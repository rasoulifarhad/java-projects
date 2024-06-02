package com.farhad.example.work_effevtively_with_legacy_code.sprout_class.demo2;

import java.time.LocalDate;

import com.farhad.example.work_effevtively_with_legacy_code.sprout_class.demo2.DatabaseStore.FakeDatabaseStore;

public class App {

    public static void main(String[] args) {
        DatabaseStore database = new FakeDatabaseStore();
        QuarterlyReportTableHeaderProducer producer = new QuarterlyReportTableHeaderProducer();
        QuarterlyReportGenerator reportGenerator = 
            new QuarterlyReportGenerator(producer,
                database, 
                LocalDate.now().minusDays(10), 
                LocalDate.now());

        System.out.println(reportGenerator.generate());
    }
}
