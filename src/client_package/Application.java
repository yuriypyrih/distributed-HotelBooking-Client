package client_package;
//ICSD16157 YURIY PYRIH
//DISTRIBUTED SYSTEMS LAB_2


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Application {
	
	private static final long serialVersionUID = -1442798787354930462L;
	
	
	public static final int WIDTH = 900, HEIGHT = WIDTH / 12 * 9; 
	
	Application(ObjectInputStream instream,ObjectOutputStream outstream){
		
		
		
		ClientManager manager = new ClientManager( instream, outstream);
		new Window(WIDTH, HEIGHT,"Hotel Booking Application", manager);
		 
	
	}

	

	
}