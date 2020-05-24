package application;

import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Break {

	private static boolean needstopBreak;
	private boolean stopBreak;

	public boolean isStopBreak() {
		return stopBreak;
	}

	public void setStopBreak(boolean stopBreak) {
		this.stopBreak = stopBreak;
	}

	public static boolean isNeedstop() {
		return needstopBreak;
	}

	public static void setNeedstopBreak(boolean needstopBreak) {
		Break.needstopBreak = needstopBreak;
	}

	public void setBreak(Label label, Label labelWhat, Button startWork, Button startBreak, Button pause1,
			Button continue1) {

		Timer timer = new Timer();
		Timer timer2 = new Timer();
		startBreak.setVisible(false);
		pause1.setVisible(false);
		continue1.setVisible(false);
		startWork.setVisible(true);

		Platform.runLater(() -> labelWhat.setText("BREAK"));
		timer.scheduleAtFixedRate(new TimerTask() {
			int min = getMinutesBreak();
			int sec = getSecondsBreak();

			@Override
			public void run() {

				if (!needstopBreak) {
					if (stopBreak) {
						pause1.setDisable(true);
						continue1.setDisable(false);
						timer2.schedule(new TimerTask() {

							@Override
							public void run() {
								try {
									Thread.sleep(1500000);

								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

							}

						}, 0, 10000);
					} else {

						pause1.setDisable(false);
						continue1.setDisable(true);
						if (!needstopBreak) {
							if (min == 0 && sec == 0) {
								Platform.runLater(() -> label.setText("Time is over"));
								timer.cancel();
								startWork.setVisible(true);
								startBreak.setVisible(true);
								resultBreak = resultBreak + 1;

								Platform.runLater(() -> labelWhat.setText("WAITING"));
								waiting2.setWaiting(label, pause1, continue1);

							} else {
								if (sec == 0) {
									min--;
									sec = 60;
								}
								sec--;
								if (sec < 10) {
									Platform.runLater(() -> label.setText("Left " + min + ":0" + sec));
								} else {
									Platform.runLater(() -> label.setText("Left " + min + ":" + sec));
								}

							}
						} else {
							timer.cancel();
						}
					}
				}
			}

		}, 20, 20);
		resultBreak = resultBreak + 1;
	}

	private int minutesBreak = 4;
	private int secondsBreak = 60;
	private int resultBreak = 0;
	private Waiting waiting2 = new Waiting();

	public int getResultBreak() {
		return resultBreak;
	}

	public void setResultBreak(int resultBreak) {
		this.resultBreak = resultBreak;
	}

	public int getSecondsBreak() {
		return secondsBreak;
	}

	public void setSecondsBreak(int secondsBreak) {
		this.secondsBreak = secondsBreak;
	}

	public int getMinutesBreak() {
		return minutesBreak;
	}

	public void setMinutesBreak(int minutesBreak) {
		this.minutesBreak = minutesBreak;
	}

}
