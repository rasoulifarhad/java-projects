package com.farhad.example.codekata.text_converter_kata;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

public class HtmlPagesConverter {

    @Getter
    private String filename;
    private List<Integer> breaks = new ArrayList<Integer>();
    
    public HtmlPagesConverter(String filename) throws IOException {
        this.filename = filename;
       
        breaks.add(0);
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        
        String line = reader.readLine();
        int cumulativeCharCount = 0;
        while (line != null) {
            cumulativeCharCount += line.length() + 1; // add one for the newline
            if(line.contains("PAGE_BREAK")) {
                int page_break_position = cumulativeCharCount;
                breaks.add(page_break_position);
            }
            line = reader.readLine();
        }

        reader.close();
    }

    public String getHtmlPage(int page) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        reader.skip(breaks.get(page));
        StringBuffer htmlPage = new StringBuffer();
        String line = reader.readLine();

        while (line != null) {
            if(line.contains("PAGE_BREAK")) {
                break;
            }
            htmlPage.append(StringEscapeUtils.escapeHtml(line));
            htmlPage.append("<br />");
            line = reader.readLine();
        }

        reader.close();
        return htmlPage.toString();
    }
    
    
}
