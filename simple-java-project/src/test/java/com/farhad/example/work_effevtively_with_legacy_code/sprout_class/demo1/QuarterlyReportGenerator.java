package com.farhad.example.work_effevtively_with_legacy_code.sprout_class.demo1;

import java.time.LocalDate;
import java.util.List;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class QuarterlyReportGenerator {

    private final DatabaseStore database;
    private final LocalDate beginDate;
    private final LocalDate endDate;

    public String generate() {
        List<Result> results = database.queryResults(beginDate, endDate);

        String pageText = "";
        pageText += "<html><head><title>";
        pageText += "Quartly Report";
        pageText += "</title></head><body><table>";

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
