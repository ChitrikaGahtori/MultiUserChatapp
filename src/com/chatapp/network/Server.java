package com.chatapp.network;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.chatapp.utils.ConfigReader;

public class Server {
	
	ServerSocket serverSocket ;
	public Server() throws IOException {
		int PORT = Integer.parseInt(ConfigReader.getValue("PORTNO"));
		serverSocket  = new ServerSocket(PORT);
		System.out.println("Server Started and waiting for the Client Connection....");
		Socket socket = serverSocket.accept(); /// HandShaking	
		System.out.println("Client Joins the Server");
		InputStream in = socket.getInputStream(); // read bytes from the network
		byte arr[] = in.readAllBytes();
		String str = new String(arr); // Bytes convert into String
		System.out.println("Message Received From the Client "+str);
		in.close();
		socket.close();
		
		socket.close();

	}

	public static void main(String[] args) throws IOException {
		Server server = new Server();
	}
}
