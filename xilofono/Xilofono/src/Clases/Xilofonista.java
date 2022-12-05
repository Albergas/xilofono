package Clases;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JFrame;

public class Xilofonista {

	private final static HashMap<KeyEvent, File> teclas = new HashMap();
	
	public static void main(String args[]) {
		
		ExecutorService pool = Executors.newCachedThreadPool();
		
		JFrame frame = new JFrame();
        frame.addKeyListener( new KeyListener()
        {

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
				Sonajero sonajero = new Sonajero(new File("alma.wav"));
				pool.execute(sonajero);

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
        
        frame.show();
	}
}
