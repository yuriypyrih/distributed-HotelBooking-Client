package client_package;
//ICSD16157 YURIY PYRIH
//DISTRIBUTED SYSTEMS LAB_2


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

import javax.swing.JOptionPane;


public class ClientManager {

	//private static LinkedList<Reservation> reservation_list = new LinkedList<Reservation>();
	private ObjectInputStream instream;
	private ObjectOutputStream outstream;
	
	public ClientManager(ObjectInputStream instream,ObjectOutputStream outstream) {
		this.instream = instream;
		this.outstream = outstream;
	}
	
	public void addObject(Reservation object) throws IOException, ClassNotFoundException {
		System.out.println("Client -> INSERT");
		outstream.writeObject(new MessageObject(REQUEST_TYPE.INSERT, object));
		MessageObject message = (MessageObject) instream.readObject();
		System.out.println("Server -> OK, WAITING");
		JOptionPane.showMessageDialog(null,(message.getREQUEST()==REQUEST_TYPE.RESPOND ? message.getMessage() : "Something went wrong.."));
		
	}

	public void removeObject(Reservation object) {
		
		System.out.println("Reservation has been removed");
		//this.reservation_list.remove(object);		
	}
	
	
	public void removeObject(String id) throws IOException, ClassNotFoundException {
		
		System.out.println("Client -> DELETE");
		outstream.writeObject(new MessageObject(REQUEST_TYPE.DELETE, id));
		MessageObject message = (MessageObject) instream.readObject();
		System.out.println("Server -> OK, WAITING");
		JOptionPane.showMessageDialog(null,(message.getREQUEST()==REQUEST_TYPE.RESPOND ? message.getMessage() : "Something went wrong.."));
	}
	
	
	
	public String getAllList() throws IOException, ClassNotFoundException {
		System.out.println("Client -> SEARCH");
		System.out.println("\"VIEW_ALL\"");
		outstream.writeObject(new MessageObject(REQUEST_TYPE.SEARCH, "VIEW_ALL"));
		MessageObject message = (MessageObject) instream.readObject();
		if(message.getREQUEST() == REQUEST_TYPE.RESPOND) {
			System.out.println("Server -> OK, WAITING");
			return message.getMessage();
		}
		else {
			return null;
		}
		
	}
	
	public String getByNameList(String name) throws IOException, ClassNotFoundException {
		System.out.println("Client -> SEARCH");
		System.out.println("\"" + name + "\"");
		outstream.writeObject(new MessageObject(REQUEST_TYPE.SEARCH, name));
		MessageObject message = (MessageObject) instream.readObject();
		if(message.getREQUEST() == REQUEST_TYPE.RESPOND) {
			System.out.println("Server -> OK, WAITING");
			return message.getMessage();
		}
		else {
			return null;
		}
	}

	
}
