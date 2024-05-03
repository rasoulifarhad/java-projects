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
        if("".equals(query)) {
            return 0;
        }
        return  1;
    }

    public Object valueFor(String string) {
        String [] nameAndVale = query.split("=");
        return nameAndVale[1];
    }

}
