package code;

import java.io.IOException;
import java.awt.EventQueue;
import GUI.MyFrame;

/**
 * Application class with main function
 * @author Mikolaj Miller
 *
 */
public class Application {
	

	/**
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException{
			
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					new MyFrame();
				} catch (IOException e) {}
			}
		});	
	}
}
