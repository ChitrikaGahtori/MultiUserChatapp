package com.chatapp.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.chatapp.dao.UserDAO;
import com.chatapp.dto.UserDTO;

public class UserScreen extends JFrame{
	private JTextField useridtxt;
	private JPasswordField passwordField;

	
	public static void main(String[] args) {
		
		UserScreen window = new UserScreen();
	}
	
	
	UserDAO userDAO = new UserDAO();
	private void register() {
		String userid = useridtxt.getText();
		//String password = passwordField.getText(); // getText will take the password as string and you can print it so for security purpose we use getpassword in char
		char []password = passwordField.getPassword(); // ClassName @HashCode(HexaDecimal)
		
		//System.out.println("userId: " + userid + "Password: "+password);
		//UserDAO userDAO = new UserDAO();
		UserDTO userDTO = new UserDTO(userid , password);
		
		try {
		int result = userDAO.addRecord(userDTO);
		if(result>0) {
			JOptionPane.showMessageDialog(this, "Register Succesfully");
			// System.out.println("Record Added....");
		}
		else {
			JOptionPane.showMessageDialog(this, "Register Fail");
			//System.out.println("Record Not Added....");
		}
		}
		
		catch(ClassNotFoundException |SQLException ex) {
			System.out.println("DB Issue ....");
			ex.printStackTrace();
		}
		catch(Exception ex) {
			System.out.println("Some Generic exception Raised...");
			ex.printStackTrace(); // Where is the Exception
		}
		
		System.out.println("userId: " + userid + " Password: "+password.toString()); // toString -> represent any object as a string
		// ClassName@HashCode(Hexa)
	}
	
	private void doLogin() {
		
		String userid = useridtxt.getText();
		//String password = passwordField.getText();
		char []password = passwordField.getPassword(); // ClassName @HashCode (HexaDecimal)
		
		// UserDAO userDAO = new UserDAO();
		UserDTO userDTO = new UserDTO(userid , password);
		try {
			String message  = "";
			if(userDAO.isLogin(userDTO)) {
				message = "Welcome "+userid;
				JOptionPane.showMessageDialog(this, message);
				setVisible(false);
				dispose();
				DashBoard dashBoard = new DashBoard(message);
				dashBoard.setVisible(true);
		}
		else {
			message = "Invalid Userid or Password";
			JOptionPane.showMessageDialog(this, message);
		}
		//JOptionPane.showMessageDialog(this, message);
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * Create the application.
	 */
	public UserScreen() {
		setResizable(false);
		setTitle("LOGIN");
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);

		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(233, 43, 140, 57);
		getContentPane().add(lblNewLabel);
		
		useridtxt = new JTextField();
		useridtxt.setBounds(251, 143, 301, 33);
		getContentPane().add(useridtxt);
		useridtxt.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(251, 220, 301, 33);
		getContentPane().add(passwordField);
		
		
		JLabel pwdlbl = new JLabel("Password");
		pwdlbl.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		pwdlbl.setBounds(134, 224, 107, 33);
		getContentPane().add(pwdlbl);
		
		
		JLabel useridlbl = new JLabel("Userid");
		useridlbl.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		useridlbl.setBounds(134, 140, 107, 33);
		getContentPane().add(useridlbl);
		
		
		JButton registerbt = new JButton("Register");
		registerbt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				register();
			}
		});
		registerbt.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		registerbt.setBounds(389, 324, 132, 41);
		getContentPane().add(registerbt);
		
		JButton loginbt = new JButton("Login");
		loginbt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				doLogin();
			}
		});
		loginbt.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		loginbt.setBounds(221, 324, 132, 41);
		getContentPane().add(loginbt);
	
		
		
		setSize(683, 521);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
