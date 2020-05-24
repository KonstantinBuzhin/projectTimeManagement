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

public class SearchController {

	
	private Recommendation recom;
	
	public Recommendation getRecom() {
		return recom;
	}

	public void setRecom(Recommendation recom) {
		this.recom = recom;
	}

	@FXML
	private Button Work;


	@FXML
	private Button Recommendation;

	@FXML
	private Label label;

	public Label getLabel() {
		return label;
	}



	@FXML
	private void showWork(ActionEvent event) throws IOException {
		
			Parent showWork = FXMLLoader.load(getClass().getResource("/PomWorkApp.fxml"));
			Scene scene = new Scene(showWork);
			
			Stage window = (Stage) (((Node) event.getSource()).getScene().getWindow());
			window.setScene(scene);
			window.show();
		
          
	}


	@FXML
	private void showRecommendation(ActionEvent event) {
		label.setText("Recomm. is "+application.Recommendation.getAmountWorkMonth());
	}

	

}
