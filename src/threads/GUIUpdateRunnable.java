package threads;

import main.VentaController;

public class GUIUpdateRunnable implements Runnable{
	
	private VentaController vc;
	private String time;
	
	public GUIUpdateRunnable(VentaController vc, String time){
		this.vc = vc;
		this.time = time;
	}
	
	@Override
	public void run(){
		vc.updateTime(time);
	}
}
