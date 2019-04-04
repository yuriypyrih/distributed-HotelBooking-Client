import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;



//ICSD16157 YURIY PYRIH
//DISTRIBUTED SYSTEMS LAB_2





public class Window extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = -8255319694373975038L;

	GridBagConstraints c = new GridBagConstraints();
	CardLayout card_layout = new CardLayout();

	private JPanel mainPanel;
	private JPanel card_welcome, card_add, card_view, card_remove;
	private JPanel card_welcome_top, card_welcome_center;
	
	private JTextField tf_first_name, tf_last_name, tf_phonenumber;
	private JButton btn_add, btn_view, btn_remove, btn_sumbit,btn_cancel;
	
	final static String WELCOME_PANEL = "Card with welcome message";
	final static String ADD_PANEL = "Card with adding a booking form";
	final static String VIEW_PANEL = "Card with view form";
	final static String REMOVE_PANEL = "Card with remove form";
	
	
	
	
	//Constructor of Window
	public Window(int width, int height, String title) {
		
			
				
				JFrame frame = new JFrame(title);
				frame.setSize(width,height);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setResizable(false);
				frame.setLocationRelativeTo(null);	
				frame.setVisible(true);
			
				
				
				
				// Creating the components
				
				mainPanel = new JPanel(card_layout);
				card_welcome = new JPanel(new BorderLayout());
				card_welcome_top = new JPanel();
				card_welcome_center = new JPanel();
				card_add = new JPanel(new GridBagLayout());
				card_view = new JPanel();
				card_remove = new JPanel();
				
				// Welcome Card
				card_welcome_top.add(new JLabel("Welcome"));
				card_welcome.add(card_welcome_top,BorderLayout.NORTH);
				
				btn_add = new JButton("New Booking");
				btn_add.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		            	card_layout.show(mainPanel, ADD_PANEL);
		            }
		        });
				btn_view = new JButton("View Bookings");
				btn_remove = new JButton("Remove Booking");
				btn_cancel = new JButton("Cancel");
				btn_cancel.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		            	card_layout.show(mainPanel, WELCOME_PANEL);
		            }
		        });
			
				card_welcome_center.add(btn_add);
				card_welcome_center.add(btn_view);
				card_welcome_center.add(btn_remove);
				card_welcome.add(card_welcome_center,BorderLayout.CENTER);
				
				
				
				
				// New Booking Card
				
				
				
			
				tf_first_name = new JTextField(15);
				tf_last_name = new JTextField(15);
				tf_phonenumber = new JTextField(15);
						
				btn_sumbit = new JButton("Sumbit");
				

				
				//c.ipadx = 0;
				c.anchor = GridBagConstraints.LINE_START;
				c.insets = new Insets(6,6,6,6);  
				c.gridx = 0;
				c.gridy = 0;
				card_add.add(new JLabel("First Name"),c);
				c.gridx = 1;
				c.gridy = 0;
				card_add.add(tf_first_name,c);
				c.gridx = 0;
				c.gridy = 1;
				card_add.add(new JLabel("Last Name"),c);
				c.gridx = 1;
				c.gridy = 1;
				card_add.add(tf_last_name,c);
				c.gridx = 0;
				c.gridy = 2;
				card_add.add(new JLabel("Phone Number"),c);
				c.gridx = 1;
				c.gridy = 2;
				card_add.add(tf_phonenumber,c);
				c.gridx = 0;
				c.gridy = 3;
				card_add.add(btn_sumbit,c);
				c.gridx = 1;
				c.gridy = 3;
				card_add.add(btn_cancel,c);
				
				
				//Adding everything together
				
				mainPanel.add(card_welcome, WELCOME_PANEL);
				mainPanel.add(card_add, ADD_PANEL);
				mainPanel.add(card_view, VIEW_PANEL);
				mainPanel.add(card_remove, REMOVE_PANEL);
				frame.add(mainPanel);
				frame.setVisible(true);
			
			
				
					
		
	}//end of Constructor








	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	









	



	

	
}//end of class Window
