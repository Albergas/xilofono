package Clases;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Principal {

	public static void main(String args[]) throws LineUnavailableException, IOException, UnsupportedAudioFileException {

		File file = new File("augh.wav");
	    AudioInputStream ais = AudioSystem.getAudioInputStream(file);
	    Clip clip = AudioSystem.getClip();
	    clip.open(ais);
	    clip.start();
	  
	    JFrame frame = new JFrame();
        frame.addKeyListener( new KeyListener()
        {

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				clip.setFramePosition(0);
                clip.start();
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
        });
 
        // JOptionPane.showMessageDialog(null, frame);
        
        frame.show();
		
		//Drums drums = new Drums("xd");
		//drums.init();
	}
}
