/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.JDevelop.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
    
    public Map<String, List<Song>> byArtist()
    {
        Map<String, List<Song>> byArtist = new HashMap<>();
        for(Song song:mSongs)
        {
            List<Song> artistSongs = byArtist.get(song.getmArtist());
            if (artistSongs == null)
            {
                artistSongs = new ArrayList<>();
                byArtist.put(song.getmArtist(), artistSongs);
            }
            artistSongs.add(song);
        }
        return byArtist;
    }
    
    public Set<String> getArtists()
    {
        return byArtist().keySet();
    }
    
    public List<Song> getSongsForArtist(String artistName)
    {
        return byArtist().get(artistName);
    }
}
