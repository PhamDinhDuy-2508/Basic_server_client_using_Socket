package Client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.rmi.server.ServerCloneException;
import java.security.KeyStore.TrustedCertificateEntry;
import java.util.Scanner;

public class main {

	public static void main(String[] args)  throws IOException , ServerCloneException{ 
		
		Socket socket =  new Socket("localhost" , 22508) ; 
		
		Scanner scanner = new Scanner(System.in) ;
		
		
		String messageString = "" ; 
		
		Message_to_Server  message_to_Server =  new Message_to_Server(socket) ; 		
		new Listen_Message_from_Server(socket).start();
		while (true ) {
			messageString =  scanner.nextLine() ; 
			
			message_to_Server.setMessageString(messageString);
			message_to_Server.Send_Message_to_Server();
			
			 		
			
		} 
		
				

	}

}
