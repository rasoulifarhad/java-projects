package com.farhad.example.codekata.text_converter_kata;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class HtmlTextConverter {

    private final String fullFilenameWithPath;

    public String convertToHtml() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fullFilenameWithPath));
        
        String line = reader.readLine();
        String html = "";
        while (line != null) {
            html += StringEscapeUtils.escapeHtml(line);
            html += "<br  />";
            line = reader.readLine();
        }

        return html;
    }


}
