package client_package;
//ICSD16157 YURIY PYRIH
//DISTRIBUTED SYSTEMS LAB_2


import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;







public class Window extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = -8255319694373975038L;
	private ClientManager manager;

	GridBagConstraints c = new GridBagConstraints();
	CardLayout card_layout = new CardLayout();

	private JPanel mainPanel;
	private JPanel card_welcome, card_add, card_view, card_remove;
	private JPanel card_welcome_top, card_welcome_center;
	
	private JTextField tf_first_name, tf_last_name, tf_phonenumber, tf_date_arrival,tf_search , tf_remove;
	private JTextArea textarea_view;
	private JComboBox comboboxSearch, comboboxRoom;
	private JCheckBox btn_include_breakast;
	private int combobox_index = 0;
	private JButton btn_add, btn_view, btn_remove, btn_sumbit,btn_search,btn_cancel_1, btn_cancel_2, btn_cancel_3;
	
	final static String WELCOME_PANEL = "Card with welcome message";
	final static String ADD_PANEL = "Card with adding a booking form";
	final static String VIEW_PANEL = "Card with view form";
	final static String REMOVE_PANEL = "Card with remove form";
	
	
	
	
	//Constructor of Window
	public Window(int width, int height, String title, ClientManager manager) {
		
			
				this.manager = manager;
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
		            	clearInput();
		            	card_layout.show(mainPanel, ADD_PANEL);
		            }
		        });
				btn_view = new JButton("View Bookings");
				btn_view.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		            	clearInput();
		            	card_layout.show(mainPanel, VIEW_PANEL);
		            }
		        });
				btn_remove = new JButton("Remove Booking");
				btn_remove.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		            	clearInput();
		            	card_layout.show(mainPanel, REMOVE_PANEL);
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
				tf_date_arrival = new JTextField(15);
				
				String[] str_comboboxRoom = { "Single","Double", "Triple"};
				comboboxRoom = new JComboBox(str_comboboxRoom);
				comboboxRoom.setSelectedIndex(0);
				
				btn_include_breakast = new JCheckBox("Included");
				
						
				btn_sumbit = new JButton("Sumbit");
				btn_sumbit.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		            	try {
							manager.addObject(new Reservation(tf_first_name.getText(), tf_last_name.getText(), tf_phonenumber.getText(), tf_date_arrival.getText(),
									comboboxRoom.getSelectedItem().toString(), btn_include_breakast.isSelected()));
						} catch (IOException | ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		            	clearInput();
		            }
		        });
				
				btn_cancel_1 = new JButton("Go Back");
				btn_cancel_1.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		            	clearInput();
		            	card_layout.show(mainPanel, WELCOME_PANEL);
		            }
		        });
				
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
				card_add.add(new JLabel("Arrival Date"),c);
				c.gridx = 1;
				c.gridy = 3;
				card_add.add(tf_date_arrival,c);
				c.gridx = 0;
				c.gridy = 4;
				card_add.add(new JLabel("Room Type"),c);
				c.gridx = 1;
				c.gridy = 4;
				card_add.add(comboboxRoom,c);
				c.gridx = 0;
				c.gridy = 5;
				card_add.add(new JLabel("Breakfast"),c);
				c.gridx = 1;
				c.gridy = 5;
				card_add.add(btn_include_breakast,c);
				c.gridx = 0;
				c.gridy = 6;
				card_add.add(btn_sumbit,c);
				c.gridx = 1;
				c.gridy = 6;
				card_add.add(btn_cancel_1,c);
				
				
				//View card
				
				tf_search = new JTextField(15);
				String[] str_comboboxSearch = { "Show ALL","Name of customer"};
				
				comboboxSearch = new JComboBox(str_comboboxSearch);
				comboboxSearch.setSelectedIndex(combobox_index);
				
				btn_search = new JButton("Search");
				btn_search.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		            	if(comboboxSearch.getSelectedIndex() == 0) {
		            		try {
								textarea_view.setText(manager.getAllList());
							} catch (ClassNotFoundException | IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
		            	}
		            	else if(comboboxSearch.getSelectedIndex() == 1) {
		            		
		            		String name = tf_search.getText();
		            		try {
								textarea_view.setText(manager.getByNameList(name));
							} catch (ClassNotFoundException | IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
		            	}
		            	
		            	clearInput();
		            }
		        });
				
				btn_cancel_2 = new JButton("Go Back");
				btn_cancel_2.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		            	clearInput();
		            	card_layout.show(mainPanel, WELCOME_PANEL);
		            }
		        });
				
				textarea_view = new JTextArea(25,80);
				JScrollPane scrollPane = new JScrollPane(textarea_view);
				textarea_view.setEditable(false);
				
				
				card_view.add(new JLabel("Search by"));
				card_view.add(comboboxSearch);
				card_view.add(tf_search);
				card_view.add(btn_search);
				card_view.add(btn_cancel_2);
				card_view.add(scrollPane);
				
				//Remove card
				
				tf_remove = new JTextField(15);
				
				btn_remove = new JButton("Remove");
				btn_remove.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		            	try {
							manager.removeObject(tf_remove.getText());
						} catch (ClassNotFoundException | IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		            	clearInput();
		            }
		        });
				
				btn_cancel_3 = new JButton("Go Back");
				btn_cancel_3.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		            	clearInput();
		            	card_layout.show(mainPanel, WELCOME_PANEL);
		            }
		        });
				
				card_remove.add(new JLabel("Remove by ID"));
				card_remove.add(tf_remove);
				card_remove.add(btn_remove);
				card_remove.add(btn_cancel_3);
				
				
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
	
	private void clearInput() {
		DateFormat date_format = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		
		tf_first_name.setText("");
		tf_last_name.setText("");
		tf_phonenumber.setText("");
		tf_date_arrival.setText(date_format.format(date));
		tf_search.setText("");
		tf_remove.setText("");
	}









	



	

	
}//end of class Window
