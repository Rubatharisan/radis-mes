package server;

import java.net.*;
import java.io.*;

import client.Configuration;

public class Server extends Thread
{
	
   private ServerSocket serverSocket;
   public static int port = 7998;
   private boolean busy;
   
   public Server() throws IOException
   {
      serverSocket = new ServerSocket(port);
      
   }

   public void run()
   {
      while(true)
      {
         try
         {
        	System.out.println(":SOCKET: Server name: "+serverSocket.getInetAddress().getHostName());
            System.out.println(":SOCKET: Waiting for :SCADA: on port " +
            serverSocket.getLocalPort() + "...");
            Socket server = serverSocket.accept();
            System.out.println(":SOCKET: Just connected to :SCADA:@"
                  + server.getRemoteSocketAddress());
        
            
            DataInputStream in =
                    new DataInputStream(server.getInputStream());
              busy = in.readBoolean();
              
            DataOutputStream out =
                 new DataOutputStream(server.getOutputStream());

            server.close();
         }catch(SocketTimeoutException s)
         {
            System.out.println(":SOCKET: Socket timed out!");
            break;
         }catch(IOException e)
         {
            e.printStackTrace();
            break;
         }
      }
   }
   
   public boolean isBusy(){
	   return busy;
   }
}

