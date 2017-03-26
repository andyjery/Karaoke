/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.JDevelop;
import com.JDevelop.model.Song;
import  com.JDevelop.model.SongBook;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Jerry
 */
public class KaraokeMachine {
    private SongBook mSongBook;
    private BufferedReader mReader;
    private HashMap<String, String> mMenu;

    public KaraokeMachine(SongBook SongBook) {
        this.mSongBook = SongBook;
        mReader = new BufferedReader(new InputStreamReader(System.in));
        mMenu = new HashMap<String, String>();
        mMenu.put("add", "Add a new song to the song book");
        mMenu.put("choose", "Choose a song to sing!");
        mMenu.put("quit", "Give up. Exit the program");
    }
    
    private String promptAction() throws IOException
    {
        System.out.printf("There are %d songs available. Your options are: %n", mSongBook.getSongCount());
        for(Map.Entry<String, String> option : mMenu.entrySet())
        {
            System.out.printf("%s - %s  %n", option.getKey(), option.getValue());
        }
        System.out.print("What do you want to do: ");
        String choice = mReader.readLine();
        
        return choice.trim().toLowerCase();
    }
    
    public void run()
    {
        String choice = "";
        do {            
            try {
                choice = promptAction();
                switch(choice)
                {
                    case "add":
                        //TODO: Add a new song
                        Song song = promptNewSong();
                        mSongBook.addSong(song);
                        System.out.printf("%s added! %n%n", song);
                        break;
                    case "choose":
                        String artist = promptArtist();
                        Song artistSong = promptSongForArtist(artist);
                        //TODO: add to a song queue
                        System.out.printf("You choose:  %s %n",artistSong );
                        break;
                    case "quit":
                        System.out.println("Thanks for playing!");
                        break;
                    default: 
                        System.out.printf("Unknown choice: '%s'. Try again. %n%n", choice);    
                }
            } catch (IOException ioe) {
                System.out.println("Problem with Input");
                ioe.printStackTrace();
            }
        } while (!choice.equals("quit"));
    }
    
    private Song promptNewSong() throws IOException
    {
        System.out.print("Enter the artist's name: ");
        String ratist = mReader.readLine();
        System.out.print("Enter the title:  ");
        String title = mReader.readLine();
        System.out.print("Enter the video URL:  ");
        String videoURL = mReader.readLine();
        return new Song(ratist, title, videoURL);
    }
    
    private String promptArtist() throws IOException
    {
        System.out.println("Available artists:");
        List<String> artists = new ArrayList<>(mSongBook.getArtists());
        int index = promptForIndex(artists);
        return artists.get(index);
    }
    
    private Song promptSongForArtist(String artist) throws IOException
    {
        List<Song> songs = mSongBook.getSongsForArtist(artist);
        List<String> songTitles = new ArrayList<>();
        for (Song song:songs)
        {
            songTitles.add(song.getmTitle());
        }
        int index = promptForIndex(songTitles);
        return songs.get(index);
    }
    
    private int promptForIndex(List<String> options) throws IOException
    {
        int count = 1;
        for (String option : options)
        {
            System.out.printf("%d.) %s %n", count, option);
            count++;
        }
        System.out.print("Your choice is:  ");
        String optionAsString = mReader.readLine();
        int choice = Integer.parseInt(optionAsString.trim());
        return count - 1;
    }
}
