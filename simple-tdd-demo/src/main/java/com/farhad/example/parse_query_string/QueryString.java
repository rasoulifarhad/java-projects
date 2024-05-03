package com.farhad.example.parse_query_string;

import java.util.HashMap;
import java.util.Map;

public class QueryString {

    Map<String, String> map = new HashMap<>();

    public QueryString(String queryString) {
        if(queryString == null) {
            throw new NullPointerException();
        }
        parseQueryString(queryString);
    }

    private void parseQueryString(String queryString) {
        
        if("".equals(queryString)) {
            return;
        }
        
        String [] pairs = queryString.split("&");
        for (String pair : pairs) {
            String [] nameValue = pair.split("=");
            map.put(nameValue[0], nameValue[1]);
        }

    }

    public Integer count() {
        return map.size();
    }

    public Object valueFor(String name) {
        return map.get(name);
    }

}
