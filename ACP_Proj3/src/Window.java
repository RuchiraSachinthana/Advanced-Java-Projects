import com.sun.prism.paint.Color;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Window {
	
	public void start(Stage stage) {
		
		// creates a blank window with the title
		stage.setTitle("My Spell Checker");
		stage.show();
		
		// sizes the window
	    BorderPane root = new BorderPane();
	    Scene scene = new Scene(root, 350, 200);
		stage.setScene(scene);
		
		/*// Create MenuBar
	    MenuBar menuBar = new MenuBar();
	    menuBar.setStyle("-fx-background-color: #7cfc00;");

	    root.setTop(menuBar);
	    
	    // Create menus
	    Menu fileMenu = new Menu("File");
	    Menu editMenu = new Menu("Edit");
	    
	    // Create MenuItems
	    MenuItem openItem = new MenuItem("Open File");
	    MenuItem saveFileItem = new MenuItem("Save File");
	    MenuItem exitItem = new MenuItem("Exit");
	    
	    MenuItem spellCheck = new MenuItem("Spell Check");

	    // operates based on the action 
	    EventHandler<ActionEvent> action = theHandler();

	    openItem.setOnAction(action);       
	    saveFileItem.setOnAction(action);        
	    exitItem.setOnAction(action); 
	    spellCheck.setOnAction(action);

	    
	    // Add menuItems to the Menus
	    fileMenu.getItems().addAll(openItem, saveFileItem, exitItem);
	    editMenu.getItems().addAll(spellCheck);
	    
	    // Add Menus to the MenuBar
	    menuBar.getMenus().addAll(fileMenu, editMenu);
	    
	    
	}
	
    
    private EventHandler<ActionEvent> theHandler() {
        return new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                MenuItem mItem = (MenuItem) event.getSource();
                String item = mItem.getText();
                if (item.equalsIgnoreCase("Open File")) {
                    OpenFile open = new OpenFile();
                    open.openFile();
                } else if (item.equalsIgnoreCase("New")) {
                    System.out.println("New");
                } else if (item.equalsIgnoreCase("Copy")) {
                    System.out.println("Copy");
                } else if (item.equalsIgnoreCase("Exit")) {
                    System.out.println("Exit");
                    Platform.exit();
                }
            }
        };*/
    }
    


	}

