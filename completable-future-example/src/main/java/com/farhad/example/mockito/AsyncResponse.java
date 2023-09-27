package com.farhad.example.mockito;

import lombok.AllArgsConstructor;
import lombok.Data;

public class AsyncResponse {
    
    public StringResult resume(StringResult result){
        return result;
    }

    public StringResult longOperation() {
        return new StringResult("Hello World");
    }

    @AllArgsConstructor
    @Data
    public static class StringResult {
        private String string;
    }

}
