package threads;

import main.MenuAdministratorController;;

public class CircleThread extends Thread{
	
	private MenuAdministratorController mac;
	
	public CircleThread(MenuAdministratorController mac) {
		this.mac = mac;
	}
	
	public void run() {
		while(true) {
			mac.moveBlueCircle();
			try {
				sleep(8);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}