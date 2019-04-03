
import java.net.*;
import java.io.*;
import java.util.Scanner;
public class Client {

	public static void main(String[] args) {

		/*
 
	 try{
		 	Socket sock = new Socket("192.168.1.4", 5500);

		 	BufferedReader instream = new BufferedReader(new InputStreamReader
		 			(sock.getInputStream()));
		 	BufferedWriter outstream = new BufferedWriter(new
		 			OutputStreamWriter(sock.getOutputStream()));


		 	System.out.println("Sending Messages to the Server...");
		 	System.out.println("Connecting to "+ sock.getInetAddress()+ " and port "+sock.getPort());
		 	System.out.println("Local Address :"+sock.getLocalAddress()+" Port:"+sock.getLocalPort());
		 	String strin, strout;

		 	Scanner in = new Scanner(System.in);
		 	do{
		 		//new Application();
		 		System.out.print("Write what the client will send: ");
		 		strout = in.nextLine();
		 		outstream.write(strout);
		 		outstream.newLine();
		 		outstream.flush();
		 		strin = instream.readLine();
		 		System.out.println("The server says: "+strin);
		 	}
		 	while (!strin.equals("bye"));
		 	instream.close();
		 	outstream.close();
		 	sock.close();
		 	System.out.println("Connection Closing...");
	 }
	 catch (IOException ex){
		 System.out.println("Connection Refused!!!");
		 
	 }
	 */
	 new Application();
	 
	}
}
	