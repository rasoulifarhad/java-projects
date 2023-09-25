package com.farhad.example.business_delegate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class YouTubeService implements VideoStreamingService {

    @Override
    public void doProcessing() {
        log.info("YouTubeService is now processing");
    }
    
}
