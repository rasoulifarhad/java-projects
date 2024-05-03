package com.farhad.example.parse_query_string;

public class QueryString {

    private String query;

    public QueryString(String query) {
        if(query == null) {
            throw new NullPointerException();
        }
        this.query = query;
    }

    public Integer count() {
        String [] pairs = query.split("&");
        return pairs.length;
    }

    public Object valueFor(String name) {
        String [] pairs = query.split("&");
        for (String pair : pairs) {
            String [] nameValue = pair.split("=");
            if(name.equals(nameValue[0])) {
                return nameValue[1];
            }
        }
        throw new RuntimeException(name + " not found");
    }

}
