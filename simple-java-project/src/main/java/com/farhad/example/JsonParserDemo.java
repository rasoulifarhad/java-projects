package com.farhad.example;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JsonParserDemo {
    public static void main(String[] args) {
        JSONObject jo = new JSONObject();
        jo.put("name", "farhad rasouli");
        jo.put("age", 45);
        jo.put("city", "tehran");

        JSONArray jsonArray = new JSONArray();
        jsonArray.put(jo);

        System.out.println(jsonArray.toString(2));
    }

    static class JsonArrayDemo {

        public static void main(String[] args) {
    
            JSONObject jo1 = new JSONObject();
            jo1.put("name", "farhad rasouli");
            jo1.put("age", 45);
            jo1.put("city", "tehran");
    
            JSONObject jo2 = new JSONObject();
            jo2.put("name", "Ali fakhar");
            jo2.put("age", 40);
            jo2.put("city", "bandarabbas");
    
            List<JSONObject> list = new ArrayList<>();
            list.add(jo1);
            list.add(jo2);

            JSONArray jsonArray = new JSONArray(list);
            jsonArray.put(Boolean.TRUE);
            jsonArray.put("hello boy");
        
            System.out.println(jsonArray.toString(1));
    
        }
    }
}
