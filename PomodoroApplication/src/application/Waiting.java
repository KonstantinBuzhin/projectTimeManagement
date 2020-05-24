package application;

import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Waiting {
	
private static boolean needstopWaiting;
	

	public static boolean isNeedstop() {
		return needstopWaiting;
	}

	public static void setNeedstopWaiting(boolean needstopWaiting) {
		Waiting.needstopWaiting = needstopWaiting;
	}
	
	public void setWaiting(Label label, Button pause1, Button continue1) {
        Timer timer = new Timer();
        pause1.setVisible(false);
        continue1.setVisible(false);
        timer.scheduleAtFixedRate(new TimerTask() {
        	int min = getMinutesWaiting();
        	int sec = getSecondsWaiting();
        	@Override
            public void run() {
        		if(!needstopWaiting) {
        		if(min==0&&sec==0) {
        			Platform.runLater(() -> label.setText("Time is over"));
					timer.cancel();
				}else {
					if (sec == 0) {
						min--;
						sec = 60;
					}
					sec--;
					if(sec<10) {
						Platform.runLater(() -> label.setText("Left " + min + ":0" + sec));
					}else {
					Platform.runLater(() -> label.setText("Left " + min + ":" + sec));
					}
				}
        		} else {
        			timer.cancel();
        		}
            }
        }, 100,100);
         
    }
	
	

	private int minutesWaiting = 0;
	private int secondsWaiting = 60;

	public int getSecondsWaiting() {
		return secondsWaiting;
	}

	public void setSecondsWaiting(int secondsWaiting) {
		this.secondsWaiting = secondsWaiting;
	}

	public int getMinutesWaiting() {
		return minutesWaiting;
	}

	public void setMinutesWaiting(int minutesWaiting) {
		this.minutesWaiting = minutesWaiting;
	}


}
