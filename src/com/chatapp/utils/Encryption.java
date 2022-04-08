package com.chatapp.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public interface Encryption {
	
	public static String passwordEncrypt(String plainPassword) throws NoSuchAlgorithmException {
		String encryptedPassword = null;
		
		MessageDigest messageDigest = MessageDigest.getInstance("MD5");  // Algorithm - MD5 for hashing of same length
		messageDigest.update(plainPassword.getBytes());
		byte [] encrypt = messageDigest.digest();
		System.out.println(encrypt);
		
		StringBuffer sb = new StringBuffer();
		for(byte b : encrypt) {
			sb.append(b);
		}
		encryptedPassword  = sb.toString();
		
		//System.out.println("Encrypted password "+encryptedPassword);
			
		
		return encryptedPassword;
	}
}
