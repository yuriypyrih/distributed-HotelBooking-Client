
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Application {
	
	private static final long serialVersionUID = -1442798787354930462L;
	
	
	public static final int WIDTH = 900, HEIGHT = WIDTH / 12 * 9; 
	
	Application(){
		
		
		
		new Window(WIDTH, HEIGHT,"Hotel Booking Application");
		 
		 System.out.println("Application Started");
	}

	

	
}