package com.chatapp.views;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame; //through ctrl+shift+o
import javax.swing.JLabel;

public class UserView extends JFrame{
	int counter;
	public UserView() {
		counter = 0;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,500);  // Size of the Screen  
		setResizable(false);
		setTitle("Login");
		setLocationRelativeTo(null); // Center of the Screen
		// setLocation(500,150);
		JLabel welcome = new JLabel("Login");
		welcome.setFont(new Font("Arial",Font.BOLD,40));
		Container container = this.getContentPane(); // Main content Area 
		container.setLayout(null);  // ByDefault it is at centre so make it null
		welcome.setBounds(170, 50, 250, 60); // (x,y,width,height)
		container.add(welcome);
		JButton button = new JButton("Count"); // Source
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				// TODO Auto-generated method stub
				counter++;
				welcome.setText("Count "+counter);
				
			}
		});
		button.setBounds(140, 300, 200, 50);
		container.add(button);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		UserView userView = new UserView();
	}
}
