package com.farhad.example.codekata.text_converter_kata;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class HtmlTextConverterTest {

    @Test
    public void foo() {
        HtmlTextConverter converter = new HtmlTextConverter("foo");
        assertEquals("fixme", converter.getFullFilenameWithPath());
    }

}
