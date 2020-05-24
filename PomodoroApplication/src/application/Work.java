package application;

import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Work {
	
	private static boolean needstop;
	private boolean pauseWork;
	
	
	public boolean getPauseWork() {
		return pauseWork;
	}

	public void setPauseWork(boolean pauseWork) {
		this.pauseWork = pauseWork;
	}

	public static boolean isNeedstop() {
		return needstop;
	}

	public static void setNeedstop(boolean needstop) {
		Work.needstop = needstop;
	}

	public void setWork(Label label, Label labelWhat, Label labelRes, Button startWork, Button startBreak, Button pause1, Button continue1) {
		startWork.setVisible(false);
		startBreak.setVisible(false);
		continue1.setVisible(true);
		pause1.setVisible(true);
		
		labelWhat.setText("WORK");
		Timer timer = new Timer();
		Timer timer2 = new Timer();
		
		timer.scheduleAtFixedRate(new TimerTask() {
			
			int min = getMinutesWork();
			int sec = getSecondsWork();
			
			
			
			@Override
			public void run() {
				
			
				if(!needstop) {
					if(pauseWork) {
						pause1.setDisable(true);
						continue1.setDisable(false);
						 timer2.schedule(new TimerTask() {

							@Override
							public void run() {
								try {
									Thread.sleep(1500000);
//									Platform.runLater(() -> label.setText("Bye"));
									
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
							}
							 
						 }, 0, 100000);
//						 timer2.cancel();
						 
					} else {
						
						pause1.setDisable(false);
						continue1.setDisable(true);
						if(!needstop) {
						if(min==0&&sec==0) {
		        			Platform.runLater(() -> label.setText("Time is over"));
							timer.cancel();
							startWork.setVisible(true);
							startBreak.setVisible(true);
							resultWork = resultWork + 1; 
							Platform.runLater(() -> labelRes.setText(""+resultWork));
							
							Platform.runLater(() -> labelWhat.setText("WAITING"));
							waiting1.setWaiting(label, pause1, continue1);

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
				}
				
				
				
			}
		}, 5, 5);
		
	}
	

	private int minutesWork = 24;
	private int secondsWork = 60;
	private int resultWork = 0;
	private Waiting waiting1 = new Waiting();

	public int getResultWork() {
		return resultWork;
	}

	public void setResultWork(int resultWork) {
		this.resultWork = resultWork;
	}

	public int getSecondsWork() {
		return secondsWork;
	}

	public void setSecondsWork(int secondsWork) {
		this.secondsWork = secondsWork;
	}

	public int getMinutesWork() {
		return minutesWork;
	}

	public void setMinutesWork(int minutesWork) {
		this.minutesWork = minutesWork;
	}

}
