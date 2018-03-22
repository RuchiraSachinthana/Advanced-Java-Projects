import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class SaveFile implements EventHandler<ActionEvent>{
	

	private TextArea textArea;
	WriteFile writeFile = new WriteFile();
	
	/*
	 *  Constructor
	 */
	public SaveFile(TextArea textArea) {
		this.textArea = textArea;
}
	
	public void handle(ActionEvent event) {
		writeFile.write(textArea.getText());
	}
	
	

}
