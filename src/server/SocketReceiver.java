package server;
import java.io.IOException;

import Model.MesController;


public class SocketReceiver implements Runnable {
	
	public void run() {
		// TODO Auto-generated method stub
		Server serv = null;
		try {
			serv = new Server();
			serv.start();

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		while(true){
			if(!serv.isBusy()){
				System.out.println(":SCADA: Live");
				MesController.scadaBusy = true;
			} else {
				System.out.println(":SCADA: Connection wait");
				MesController.scadaBusy = false;						
			}
			try {
				Thread.sleep((long) 1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}	
}
