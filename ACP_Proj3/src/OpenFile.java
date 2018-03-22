import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextAreaBuilder;
import javafx.scene.layout.VBox;
import javafx.scene.layout.VBoxBuilder;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.awt.Desktop;

public class OpenFile implements EventHandler<ActionEvent>{
	
	FileChooser fileChooser = new FileChooser();
	  private Desktop desktop = Desktop.getDesktop();
	
	public void handle(ActionEvent event) {
		Window stage = null;
		File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            openFile(file);
        }
	}
	
	private void openFile(File file) {
        try {
        	desktop.open(file);
        } catch (IOException ex) {
            Logger.getLogger(
                OpenFile.class.getName()).log(
                    Level.SEVERE, null, ex
                );
        }
		
		 
}
}
