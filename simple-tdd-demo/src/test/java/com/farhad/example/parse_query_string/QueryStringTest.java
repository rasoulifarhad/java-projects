package com.farhad.example.parse_query_string;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class QueryStringTest {

    @Test
    public void testOneNameValuePair() {
        QueryString qs = new QueryString("name=value");
        assertEquals(1, qs.count());
    }
}
