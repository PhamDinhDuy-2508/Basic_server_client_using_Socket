package Client;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Listen_Message_from_Server  extends Thread{
	
	
	private Socket socket ;

	public Listen_Message_from_Server(Socket socket) {
		super();
		this.socket = socket;
	}    
	
	public void Listen_from_Server() {
		System.out.println(Thread.currentThread().getName());

		try {
			BufferedReader inputReader =  new BufferedReader(
					new InputStreamReader(socket.getInputStream())) ;
			System.out.println("asdasddas");

			while (true) { 
					String chechString =  inputReader.readLine() ;
					if(chechString == null) {
						System.out.println("NULL");
					}

					System.out.println(chechString);
									
			}
							
			
		} 
		catch (Exception e) { 
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public synchronized void run() {
		Listen_from_Server();
		super.run();
	}
	
		
	
	
	
	}
	

