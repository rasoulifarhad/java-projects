package com.farhad.example.parse_query_string;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class QueryStringTest {

    @Test
    public void testOneNameValuePair() {
        QueryString qs = new QueryString("name=value");
        assertEquals(1, qs.count());
    }

    @Test
    public void testNoNameValuePairs() {
        QueryString qs = new QueryString("");
        assertEquals(0, qs.count());
    }

    @Test
    public void testNull() {
        assertThrows(NullPointerException.class, 
        () -> {
            new QueryString(null);
        });
    }
}
