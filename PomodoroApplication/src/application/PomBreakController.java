package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class PomBreakController implements Initializable{

	private Break break1 = new Break();
	
	@FXML
	private Label labelBreak;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		break1.setBreak(labelBreak);
	}
}
