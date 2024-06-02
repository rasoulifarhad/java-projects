package com.farhad.example.work_effevtively_with_legacy_code.sprout_class.demo3;

public class QuarterlyReportTableHeaderGenerator implements HTMLGenerator {

    public String generate() {
        return "<tr><td>Department</td><td>Manager</td><td>Profit</td><td>Expenses</td></tr>";
    }
}
