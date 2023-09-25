package com.farhad.example.business_delegate;

public class App {
    
    public static void main(String[] args) {
        
        BusinessLookup businessLookup = new BusinessLookup(
            new NetflixService(), 
            new YouTubeService());
        BusinessDelegate businessDelegate = new BusinessDelegate(businessLookup);

        MobileClient mobileClient = new MobileClient(businessDelegate);
        mobileClient.playbackMovie("Die Hard 2");
        mobileClient.playbackMovie("Maradona: The Greatest Ever");
    }
}
