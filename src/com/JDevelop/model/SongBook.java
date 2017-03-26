/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.JDevelop.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jerry
 */
public class SongBook {
    private List<Song> mSongs;
    
    public SongBook() {
        mSongs = new ArrayList<>();
    }
    
    public void addSong(Song song) {
        mSongs.add(song);
    }
    
    public int getSongCount() {
        return mSongs.size();
    }
}
