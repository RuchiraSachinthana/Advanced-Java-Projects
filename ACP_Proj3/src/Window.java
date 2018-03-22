import java.awt.TextArea;

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
		
		// Create MenuBar
	    MenuBar menuBar = new MenuBar();
	    menuBar.setStyle("-fx-background-color: #FF7F50;");
	    

	    // Set MenuBar to display at the top of the border pane
	   root.setTop(menuBar);
	    
	    // Create menus
	    Menu fileMenu = new Menu("File");
	    Menu editMenu = new Menu("Edit");
	    
	    
	    // Create MenuItems and instances of the individual classes to follow the functionality 
	    MenuItem openItem = new MenuItem("Open File");
	    OpenFile open = new OpenFile();
	    openItem.setOnAction(open);
	    
	    MenuItem saveItem = new MenuItem("Save File");
	    
	    MenuItem exitItem = new MenuItem("Exit");
	    exitItem.setOnAction(actionEvent -> Platform.exit());
	    
	    MenuItem spellCheck = new MenuItem("Spell Check");

	    // Add MenuItems to the Menus
	    fileMenu.getItems().addAll(openItem, saveItem, exitItem);
	    editMenu.getItems().addAll(spellCheck);
	    
	    // get the menus to display on the screen 
	    menuBar.getMenus().addAll(fileMenu, editMenu);
    }
    


	}

