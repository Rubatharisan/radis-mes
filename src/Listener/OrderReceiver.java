package Listener;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Observable;
import java.util.Properties;

import javax.jms.BytesMessage;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import Model.MesController;
import XML.XMLOrderImporter;

public class OrderReceiver extends Observable {
	
	private boolean nothingReceived  = false;
	private String s;
	private MesController mes;
	
	public static void main(String[] args) throws InterruptedException {
		
			new OrderReceiver().ReceiveXML();
		
	}
	
	public void ReceiveXML() {

	              
		try {
			
			// TODO Auto-generated method stub
			Properties env = new Properties( );
			
			 // ... specify the JNDI properties specific to the vendor
	        InitialContext jndi;
	        
	        
			jndi = new InitialContext(env);
			
			QueueConnectionFactory queueConnectionFactory =
	    			(QueueConnectionFactory) jndi.lookup("jms/__defaultConnectionFactory");
	    			
	    	// Look up a JMS Queue
	        Queue textqueue = (Queue) jndi.lookup("textqueue");
	        Queue bytequeue = (Queue) jndi.lookup("bytequeue");
	        
	        
	        // Create a JMS connection
	     		QueueConnection queueConnection = queueConnectionFactory.createQueueConnection();
	     		Session session =  queueConnection.createSession(false,
	     				Session.AUTO_ACKNOWLEDGE);
	     		
	     		queueConnection.start();
	     		while (true)
	     	      {
	     			MessageConsumer TextmessageConsumer = session.createConsumer(textqueue);
	     			MessageConsumer BytemessageConsumer =  session.createConsumer(bytequeue);
	     			
	     			System.out.println("========Receiving message==========");
	     			
	     	        TextMessage textMessage = (TextMessage) TextmessageConsumer.receive();
	     	        BytesMessage byteMessage = (BytesMessage) BytemessageConsumer.receive();
	     	        
	     	        
	     	        if (textMessage != null)
	     	        {
	     	        	s = textMessage.getText();
	    	     		
	    	     		System.out.println("TextMessage: " + s);
	    	  
	     	        }
	     	        if(byteMessage != null){
	     	       	System.out.println("Received message with: " + byteMessage.getBodyLength() + 
    	     				" bytes. Now streaming to file on disk.");
    	     		     		
    	     		
    	     		File file = new File(s);
    	     		FileOutputStream fos = new FileOutputStream(file);
    	     		
    	     		BufferedOutputStream outBuf = new BufferedOutputStream(fos);
    	     		
    	     		int i;
    	     		while((i=byteMessage.readInt())!=-1){
    	     		   outBuf.write(i);
    	     		   
    	     		  	     		 	     		  	     		 	     		  
    	     		}
    	     		
    	     		 
    	     		outBuf.close();
    	     		fos.close();
    	     		
    	     		System.out.println("File streamed to disk. Size of received file on disk is " + byteMessage.getBodyLength());
    	     		
    	     		System.out.println("=======Saving the order to Database=========");
	     			
    	     		mes.processXML(file);
    	     		
    	     		file.delete();
	     	        }
	     	        
	     	      }
	     		    

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    		}
}
