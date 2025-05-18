package com.farhad.example.birdfeeder;

import java.io.File;

public class Song {

    private File song;

    public Song(File song) {
        this.song = song;
    }

    @Override
    public boolean equals(Object aSong) {
        if(aSong instanceof Song) {
            Song otherSong = (Song) aSong;
            return this.song.equals(otherSong.song);
        }
        return false;
    }

    
}
