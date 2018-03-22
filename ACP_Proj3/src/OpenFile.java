import java.io.File;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * @author Keenal
 * COP 4027 Advanced Computer Programming
 * Project 3
 * 
 * This class has the handle method for Opening the file. It will put the file in text area.
 */
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
				// Place the text from the text file onto the textArea
				textArea.setText(read.readFile(file));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }
	}

