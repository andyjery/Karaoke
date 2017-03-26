/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import com.JDevelop.KaraokeMachine;
import com.JDevelop.model.Song;
import com.JDevelop.model.SongBook;
/**
 *
 * @author Jerry
 */
public class Karaoke {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SongBook songBook = new SongBook();
        KaraokeMachine machine = new KaraokeMachine(songBook);
        machine.run();
    }
    
}
