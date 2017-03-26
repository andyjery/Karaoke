/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.JDevelop.model;

/**
 *
 * @author Jerry
 */
public class Song {
    private String mArtist;
    private String mTitle;
    private String mVideoUrl;

    public Song(String artist, String title, String videoUrl) {
        this.mArtist = artist;
        this.mTitle = title;
        this.mVideoUrl = videoUrl;
    }

    public String getmTitle() {
        return mTitle;
    }

    public String getmArtist() {
        return mArtist;
    }

    public String getmVideoUrl() {
        return mVideoUrl;
    }

    @Override
    public String toString() {
        return String.format("Song: %s by %s", mTitle, mArtist);
    }
    
    
}
