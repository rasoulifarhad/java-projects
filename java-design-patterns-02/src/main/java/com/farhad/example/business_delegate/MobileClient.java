package com.farhad.example.business_delegate;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MobileClient {
    
    private final BusinessDelegate businessDelegate;

    public void playbackMovie(String movie) {
        businessDelegate.playbackMovie(movie);
    }
}
