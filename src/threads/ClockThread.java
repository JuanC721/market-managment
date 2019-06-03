package threads;

import java.util.*;

import javafx.application.Platform;
import main.VentaController;

public class ClockThread extends Thread{
		
	private VentaController vc;
	
	String hour;
	String minutes;
	String seconds;
	String timeDay;
	Calendar calendar;
	
	public ClockThread(VentaController vc) {
		this.vc = vc;
	}
	
	@Override
	public void run() {
		int x = 1, y = 1;
		while(x == y) {
			calculate();
			String time = hour + ":" + minutes + ":" + seconds + " " + timeDay;
			GUIUpdateRunnable fx = new GUIUpdateRunnable(vc, time);
			Platform.runLater(fx);
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void calculate() {
		calendar = new GregorianCalendar();
		Date actualTime = new Date();
		
		calendar.setTime(actualTime);
		timeDay = calendar.get(Calendar.AM_PM)==Calendar.AM ? "AM" : "PM" ;
		if(timeDay.equals("PM")) {
			int h = calendar.get(Calendar.HOUR_OF_DAY) - 12;
			hour = (h > 9) ? "" + h : "0" + h; 
		}else {
			hour =  (calendar.get(Calendar.HOUR_OF_DAY) > 9 ) ? "" + calendar.get(Calendar.HOUR_OF_DAY) : "0" + calendar.get(Calendar.HOUR_OF_DAY);
		}
		minutes = (calendar.get(Calendar.MINUTE) > 9 ) ? "" + calendar.get(Calendar.MINUTE) : "0" + calendar.get(Calendar.MINUTE);
		seconds = (calendar.get(Calendar.SECOND) > 9 ) ? "" + calendar.get(Calendar.SECOND) : "0" + calendar.get(Calendar.SECOND);
		
	}
}