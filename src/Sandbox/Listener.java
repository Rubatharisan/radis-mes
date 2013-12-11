package Sandbox;

import java.io.IOException;

import javax.jms.JMSException;
import javax.naming.NamingException;

public class Listener extends Thread {

	public void run(){
		while(true){
				try {
					System.out.println("Hi");
					LxmlReceiver res = new LxmlReceiver();
					res.ReceiveXML("hi.xml");
				} catch (NamingException | JMSException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
