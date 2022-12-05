package Clases;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineEvent.Type;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sonajero extends Thread {

	private File file;
	private final BlockingQueue<URL> queue = new ArrayBlockingQueue<URL>(1);
	
	public Sonajero(File file) {
		this.file = file;
	}
	
	public void run() {

		System.out.println("alma que paranoia, entré en la ceboia");
		AudioInputStream ais = null;
		Clip clip = null;
		try {
			ais = AudioSystem.getAudioInputStream(file);
			clip = AudioSystem.getClip();
			System.out.println("Almai, entre en el try");
		    clip.open(ais);
		    clip.start();
		    /*
		    LineListener listener = new LineListener() {
		        public void update(LineEvent event) {
		                if (event.getType() != Type.STOP) {
		                    return;
		                }

		                try {
		                    queue.take();
		                } catch (InterruptedException e) {
		                    //ignore this
		                }
		        }
		    };
			clip.addLineListener(listener );
			*/

		} catch (UnsupportedAudioFileException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LineUnavailableException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			/*
			if(clip != null) {
				clip.close();
				System.out.println("Cerrao");
			}
			else {
				System.out.println("El mundo al revés, no se por qué, pero clip nulo no es");
			}
			*/
			if(ais != null) {
				try {
					ais.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			}
		}
	    
	}
