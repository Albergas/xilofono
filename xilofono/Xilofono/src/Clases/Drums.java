package Clases;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Drums extends Applet implements KeyListener{

	//declaring Audio variables
    File file;
    AudioInputStream ais;
    Clip clip;
    
    public Drums(String a) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
    	file = new File("augh.wav");
        ais = AudioSystem.getAudioInputStream(file);
        clip = AudioSystem.getClip();
        clip.open(ais);
    }
    
    @Override
    public void init() {
    	System.out.println("xd");
        addKeyListener(this); //to detect the press of a key
    }

    @Override
    public void paint(Graphics g){
        //display message as to which key to press to play a sound
    	
    }

    @Override
    public void keyPressed(KeyEvent K){

        int X = K.getKeyCode();
        if(X == 65) {
        	System.out.println("La pulsaste xd");
        	clip.start(); //play kick.wav when K is pressed
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent K){}

    @Override
    public void keyTyped(KeyEvent K){}
}
