import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * @author Keenal
 * COP 4027 Advanced Computer Programming
 * Project 3
 * 
 * This is handle class for Spell Menu. It opens the file and does a spell check on it. 
 */

public class SpellMenu implements EventHandler<ActionEvent>{
	
	private TextArea textArea;
	
	public SpellMenu(TextArea textArea) {
		this.textArea = textArea;
}
	
	public void handle(ActionEvent event) {
	//	System.out.println("test1");
		SpellCheck checker = new SpellCheck();
	//	System.out.println("test2");
		checker.openFile("Words.txt");
	//	System.out.println("test3");
		String word = textArea.getText();
	//	System.out.println("test4");
		checker.splitString(word);
	//	System.out.println("test5");
		
	}

}
