package com.farhad.example.parse_query_string;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class QueryStringTest {

    @Test
    public void testOneNameValuePair() {
        QueryString query = new QueryString("name=value");
        assertEquals(1, query.count());
        assertEquals("value", query.valueFor("name"));
    }

    @Test
    public void testNoNameValuePairs() {
        QueryString query = new QueryString("");
        assertEquals(0, query.count());
    }

    @Test
    public void testNull() {
        assertThrows(NullPointerException.class, 
        () -> {
            new QueryString(null);
        });
    }

    @Test
    public void testMultipleNameValuePairs() {

        QueryString query = new QueryString("name1=value1&name2=value2&name3=value3");
        assertEquals("value1", query.valueFor("name1"));
        assertEquals("value2", query.valueFor("name2"));
        assertEquals("value3", query.valueFor("name3"));
    }
}
