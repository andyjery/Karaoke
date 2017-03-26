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
import java.util.HashMap;
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
}
