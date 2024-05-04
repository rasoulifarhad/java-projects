package com.farhad.example.decorator;

import lombok.Getter;

public class PhotoImage {

    @Getter
    String title;
    String fileName;

    int pixWidth;
    int pixHeight;

    

    public PhotoImage() {
    }

    public PhotoImage(String title, String fileName) {
        this.title = title;
        this.fileName = fileName;
    }

    public String getDescription() {
        return getTitle();
    }

    @Override
    public String toString() {
        return getDescription();
    }

    
}
