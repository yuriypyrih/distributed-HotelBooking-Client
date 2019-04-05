import java.util.LinkedList;

import javax.swing.JOptionPane;


public class Manager {

	private static LinkedList<Reservation> reservation_list = new LinkedList<Reservation>();
	
	
	
	
	
	public void addObject(Reservation object) {
		
		System.out.println(object + " Reservation has been added");
	this.reservation_list.add(object);
	}

	public void removeObject(Reservation object) {
		
		System.out.println(object + " Reservation has been removed");
	this.reservation_list.remove(object);		
	}
	
	public void removeObject(String id) {
		
		System.out.println(id + " Reservation has been removed");
		for( Reservation reservation : reservation_list) {
			if(reservation.getID().equals(id)) {
				this.reservation_list.remove(reservation);	
				 JOptionPane.showMessageDialog(null,"Reservation removed.");
				return;
			}
		}	
		 JOptionPane.showMessageDialog(null,"Reservation with such ID does not exist!", "Not Found",JOptionPane.ERROR_MESSAGE);
	}
	
	
	
	public String getAllList() {
		StringBuilder str_list = new StringBuilder("ID\tName\tSurname\tPhone\tDate\tRoom Type\tBreakfast Included\n");
		for( Reservation reservation : reservation_list) {
			str_list.append(reservation.toString());
		}
		System.out.println(str_list.toString());
		return str_list.toString();
	}
	
	public String getByNameList(String name) {
		StringBuilder str_list = new StringBuilder("ID\tName\tSurname\tPhone\tDate\tRoom Type\tBreakfast Included\n");
		for( Reservation reservation : reservation_list) {
			
			if(reservation.getFirstName().equals(name) || reservation.getLastName().equals(name)) {
				str_list.append(reservation.toString());
			}
			
		}
		System.out.println(str_list.toString());
		return str_list.toString();
	}

}
