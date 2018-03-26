

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Window extends Application {
	
	public void start(Stage stage) throws IOException {
		
		/*
		// creates a blank window with the title
			stage.setTitle("Horse Race");
			stage.show();
			
		// sizes the window
		    BorderPane root = new BorderPane();
		    Scene scene = new Scene(root, 550, 400);
		    stage.setScene(scene);
		    root.setStyle("-fx-background-color: #000000;");
		    
		    */
		    
		    Parent root = FXMLLoader.load(getClass().getResource("Sample.fxml"));
		    
	        Scene scene = new Scene(root, 600, 400);
	    
	        stage.setTitle("Horse Race");
	        stage.setScene(scene);
	        stage.show();
				
	}

}
