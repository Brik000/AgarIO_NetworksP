package conexion;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javafx.util.Pair;



public class WebServer {
	
	public WebServer(ArrayList<Pair<String, String>> playersInfo,String c)
	{
		System.out.println("Webserver Started");
		try {
			ServerSocket serverSocket =  new ServerSocket(8080);
			while(true) 
			{
				System.out.println("Waiting for the client request");
				Socket remote = serverSocket.accept();
				System.out.println("Connection made");
				new Thread(new ClientHandler(remote,playersInfo,c)).start();
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}



}
