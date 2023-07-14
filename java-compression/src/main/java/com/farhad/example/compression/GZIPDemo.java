package com.farhad.example.compression;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

public class GZIPDemo {
    
    @NoArgsConstructor
    @lombok.Data
    @AllArgsConstructor
    static class Bill implements Serializable {
        private String billNo;
        private String buyerName;
    }

    
}
