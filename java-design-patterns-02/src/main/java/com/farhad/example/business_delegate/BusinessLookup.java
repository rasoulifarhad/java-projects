package com.farhad.example.business_delegate;

import java.util.Locale;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BusinessLookup {
    
    private NetflixService netflixService;
    private YouTubeService youTubeService;

    public VideoStreamingService getBusinessService(String movie) {
        if(movie.toLowerCase(Locale.ROOT).contains("die hard")) {   
            return netflixService;
        }
        return youTubeService;
    }
}
