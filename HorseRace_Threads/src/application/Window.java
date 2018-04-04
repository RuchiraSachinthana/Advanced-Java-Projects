package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Window extends Application {
	
	private String stageTitle = "Horse Race";
	
	public void start(Stage stage) throws IOException {
		
		Parent root = FXMLLoader.load(getClass().getResource("Sample.fxml"));
		
		Scene scene = new Scene(root, 600, 400);
		    
        stage.setTitle(stageTitle);
        stage.setScene(scene);
        stage.show();
		
	}

}

