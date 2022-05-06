package Server;

import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore.TrustedCertificateEntry;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import Client.Message_to_Server;

public class main { 	
	
	public static void main(String [] argStrings ) { 
		
		ExecutorService executorService =  Executors.newFixedThreadPool(3) ; 
		ArrayBlockingQueue<Listren_to_client> listren_to_clients  = new ArrayBlockingQueue<>(3) ;  
			
		try {
			ServerSocket serverSocket  =  new ServerSocket(22508) ; 
			
			System.out.println("Server is ready"); 
			
			Scanner scanner = new Scanner(System.in) ; 
			
			
			Listren_to_client listren_to_client =  new Listren_to_client(serverSocket.accept(), listren_to_clients);
			executorService.execute(listren_to_client);		
			
			
			while(true ) { 			

				String uString = scanner.nextLine() ;  

				if(!uString.isEmpty()) {
					System.out.println("check");
					listren_to_client.Send_Message_to_Client(uString); 
				} 
										
			}

		} catch (Exception e) { 
			System.out.println(e.getMessage());
		}		
		
		
	}

}
