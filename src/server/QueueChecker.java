package server;
import Model.MesController;


public class QueueChecker implements Runnable{
	
	@Override
	public void run() {
		
		// TODO Auto-generated method stub
		while(true){
			if(MesController.scadaBusy){
				MesController.theQueue.poll().sendRecipe();
				System.out.println("Sending file");
			} else {
				System.out.println("Waiting");
			}
			try {
				Thread.sleep((long) 30000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
	}
	
}
