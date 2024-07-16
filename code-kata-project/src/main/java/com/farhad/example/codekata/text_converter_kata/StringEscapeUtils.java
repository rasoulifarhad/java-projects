package com.farhad.example.codekata.text_converter_kata;

public class StringEscapeUtils {

    public static String escapeHtml(String input) {
        String output = input;
        output = output.replace("&", "&amp;");
        output = output.replace("<", "&lt;");
        output = output.replace(">", "&gt;");
        output = output.replace("\"", "&quot;");
        output = output.replace("'", "&quot;");
        return output;
    }
}
