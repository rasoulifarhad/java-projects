package com.farhad.example.parse_query_string;

import java.util.HashMap;
import java.util.Map;

public class QueryString {

    private String query;

    public QueryString(String query) {
        if(query == null) {
            throw new NullPointerException();
        }
        this.query = query;
    }

    public Integer count() {
        if("".equals(query)) {
            return 0;
        }
        String [] pairs = query.split("&");
        return pairs.length;
    }

    public Object valueFor(String name) {
        Map<String, String> map = new HashMap<>();
        String [] pairs = query.split("&");
        for (String pair : pairs) {
            String [] nameValue = pair.split("=");
            map.put(nameValue[0], nameValue[1]);
        }
        return map.get(name);
    }

}
