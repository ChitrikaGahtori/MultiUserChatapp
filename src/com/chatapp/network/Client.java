package com.chatapp.network;

import java.io.IOException;
import java.net.Socket;
import java.io.OutputStream;
import java.net.UnknownHostException;
import java.util.Scanner;

import com.chatapp.utils.ConfigReader;

public class Client {
	
	Socket socket ;
	public Client() throws UnknownHostException, IOException {
		int PORT = Integer.parseInt(ConfigReader.getValue("PORTNO"));
		socket = new Socket(ConfigReader.getValue("SERVER_IP"), PORT);
		System.out.println("Client Comes");
		System.out.println("Enter the Message Send to the Server.....");
		Scanner scanner= new Scanner(System.in);
		String message = scanner.nextLine();
		OutputStream out = socket.getOutputStream(); // to write -> Write Bytes on Network 
		out.write(message.getBytes());
		System.out.println("Message Send to the Server");
		scanner.close();
		out.close();
		socket.close();
	}
	public static void main(String[] args) throws UnknownHostException, IOException {
		Client client = new Client();
	}

}
