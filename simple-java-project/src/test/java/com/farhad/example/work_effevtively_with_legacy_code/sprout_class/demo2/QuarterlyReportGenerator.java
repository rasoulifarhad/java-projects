package com.farhad.example.work_effevtively_with_legacy_code.sprout_class.demo2;

import java.time.LocalDate;
import java.util.List;

import lombok.RequiredArgsConstructor;

// Let’s suppose that the change that we need to make to the code is to add a
// header row for the HTML table it’s producing. The header row should look
// something like this:
// "<tr><td>Department</td><td>Manager</td><td>Profit</td><td>Expenses</td></tr>"
@RequiredArgsConstructor
public class QuarterlyReportGenerator {

    private final QuarterlyReportTableHeaderProducer producer;
    private final DatabaseStore database;
    private final LocalDate beginDate;
    private final LocalDate endDate;

    public String generate() {
        List<Result> results = database.queryResults(beginDate, endDate);

        String pageText = "";
        pageText += "<html><head><title>";
        pageText += "Quartly Report";
        pageText += "</title></head><body><table>";
        pageText += producer.makeHeader();

        if(results.size() > 0) {

            for (Result result : results) {
                pageText += "<tr>";
                pageText += "<td>" + result.getDepartment() + "</td>";
                pageText += "<td>" + result.getManager() + "</td>";
                pageText += String.format("<td>%d</td>", result.getNetProfit() / 100);
                pageText += String.format("<td>%d</td>", result.getOperationExpense() / 100);
                pageText += "<td>" + result.getManager() + "</td>";
                pageText += "</tr>";
            }
        } else {
            pageText += "No results for this period";
        }

        pageText += "</table>";
        pageText += "</body>";
        pageText += "</html>";

        return pageText;
    }


}
