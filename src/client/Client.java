package client;

import java.net.*;
import java.io.*;


public class Client
{
   public static void main(String [] args)
   {
      String serverName = "10.126.60.222";
      int port = 7999;
      
      try
      {
    	  
         System.out.println(":SOCKET: Connecting to " + serverName
                             + " on port " + port);
         Socket client = new Socket(serverName, port);
         
         System.out.println(":SOCKET: Just connected to "
                      + client.getRemoteSocketAddress());
         OutputStream outToServer = client.getOutputStream();
         DataOutputStream out =
                       new DataOutputStream(outToServer);
         ObjectOutputStream objectOut = new ObjectOutputStream(outToServer);
//         objectOut.writeObject(new Configuration(450, 200, 0, 21));
         
         out.writeUTF("Hello from "
                      + client.getLocalSocketAddress());
         
         client.close();
      }catch(IOException e)
      {
         e.printStackTrace();
      }
   }
   
   
}

