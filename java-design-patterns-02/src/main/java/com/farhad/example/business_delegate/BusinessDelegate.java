package com.farhad.example.business_delegate;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BusinessDelegate {
    
    private BusinessLookup businessLookup;

    public void playbackMovie(String movie) {
        VideoStreamingService videoStreamingService = businessLookup.getBusinessService(movie);
        videoStreamingService.doProcessing();
    }
}
