package com.sample.identify;

import java.io.IOException;
import java.net.InetAddress;

public class NetworkScanner {
	
	String subnet;
    int timeout; 
    InetAddress inetAddress;
	
	public NetworkScanner() {
		
		subnet = "192.168.107";
		timeout = 1000; // Timeout for ping in milliseconds
		
		System.out.println("Scanning....");

        for (int i = 1; i <= 255; i++) {
        	
            String host = subnet + "." + i;
            
            try {
            	
                inetAddress = InetAddress.getByName(host);
                
                if (inetAddress.isReachable(timeout)) {
                	
                    System.out.println("Host: " + host + " is reachable");
                    
                }
            } catch (IOException e) {
            	
                System.err.println("Error while scanning host: " + host + " - " + e.getMessage());
                
            }
        }
		
	}
	
    public static void main(String[] args) {
        new NetworkScanner();
    }
}