import java.io.File;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

public class OpenFile implements EventHandler<ActionEvent>{
	
	ReadFile read = new ReadFile();
	private TextArea textArea;
	private Stage stage;
	
	/*
	 *  Constructor
	 */
	public OpenFile(TextArea textArea, Stage stage) {
		this.textArea = textArea;
		this.stage = stage;
}
	
	public void handle(ActionEvent action) {
		FileChooser fileChooser = new FileChooser();
        
        //Set extension filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);
         
        
		
		//Show save file dialog
        File file = fileChooser.showOpenDialog(stage);
        if(file != null){
           
			try {
				textArea.setText(read.readFile(file));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }
	}

