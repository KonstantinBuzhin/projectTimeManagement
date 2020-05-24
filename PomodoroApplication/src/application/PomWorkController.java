package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class PomWorkController implements Initializable{

	private Work work1 = new Work();
	private Break break1 = new Break();
	private Waiting waiting1 = new Waiting();
	@FXML
	private Label labelWork;
	
	@FXML
	private Label labelWhat;

	@FXML
	private Label resWork;
	 
	@FXML
	private Button startWork;
	
	@FXML
	private Button startBreak;
	
	@FXML
	private Button pause;
	
	@FXML
	private Button continueTimer;
	
	@FXML
	private Button home;
	
	
	@FXML
	public void goHome(ActionEvent event) throws IOException {
		Parent showHome = FXMLLoader.load(getClass().getResource("/PomApp.fxml"));
		Scene scene = new Scene(showHome);
		
		Stage goHome = (Stage) (((Node) event.getSource()).getScene().getWindow());
		goHome.setScene(scene);
		goHome.show();
	}
	

	
	@FXML
	public void showStop(ActionEvent event) {
		work1.setPauseWork(true);
		break1.setStopBreak(false);
		
		
	}
	
	@FXML
	public void showContinueTimer(ActionEvent event) {
		work1.setPauseWork(false);
		
	}
	
	@FXML
	public void showStartWork(ActionEvent event) {
		break1.setNeedstopBreak(false);
		work1.setNeedstop(true);
		break1.setNeedstopBreak(true);
		waiting1.setNeedstopWaiting(true);
		work1.setNeedstop(false);
		work1.setWork(labelWork, labelWhat, resWork, startWork, startBreak, pause, continueTimer);
		
		
	}
	
	@FXML
	public void showStartBreak(ActionEvent event) {
		work1.setNeedstop(true);
		break1.setNeedstopBreak(true);
		waiting1.setNeedstopWaiting(true);
		break1.setNeedstopBreak(false);
		break1.setBreak(labelWork, labelWhat, startWork, startBreak, pause, continueTimer);
		
	}
	


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		work1.setWork(labelWork, labelWhat, resWork, startWork, startBreak, pause, continueTimer);
		resWork.setText(""+work1.getResultWork());
	}

	
}
