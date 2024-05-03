package com.farhad.example.parse_query_string;

import java.util.HashMap;
import java.util.Map;

public class QueryString {

    private String query;
    Map<String, String> map = new HashMap<>();

    public QueryString(String queryString) {
        if(queryString == null) {
            throw new NullPointerException();
        }
        this.query = queryString;
        parseQueryString(queryString);
    }

    private void parseQueryString(String queryString) {
        if(!"".equals(queryString)) {
            String [] pairs = query.split("&");
            for (String pair : pairs) {
                String [] nameValue = pair.split("=");
                map.put(nameValue[0], nameValue[1]);
            }
            }
    }

    public Integer count() {
        if("".equals(query)) {
            return 0;
        }
        String [] pairs = query.split("&");
        return pairs.length;
    }

    public Object valueFor(String name) {
        
        String [] pairs = query.split("&");
        for (String pair : pairs) {
            String [] nameValue = pair.split("=");
            map.put(nameValue[0], nameValue[1]);
        }
        return map.get(name);
    }

}
