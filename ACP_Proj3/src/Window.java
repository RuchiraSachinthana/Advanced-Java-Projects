
import java.io.File;
import java.io.IOException;

import com.sun.prism.paint.Color;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextAreaBuilder;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Window extends Application{

	public void start(Stage stage) throws Exception{
		
		// creates a blank window with the title
		stage.setTitle("My Spell Checker");
		stage.show();
		
		// sizes the window
	    BorderPane root = new BorderPane();
	    Scene scene = new Scene(root, 550, 400);
	    stage.setScene(scene);
		
		// Create MenuBar
	    MenuBar menuBar = new MenuBar();
	    menuBar.setStyle("-fx-background-color: #FF7F50;");
	    root.setTop(menuBar);
	    
	    // Create menus
	    Menu fileMenu = new Menu("File");
	    Menu editMenu = new Menu("Edit");
	    
	    // Create MenuItems - openItem 
	    MenuItem openItem = new MenuItem("Open File");
	    TextArea textArea = new TextArea();
	    textArea.setWrapText(true);
	    OpenFile openAction = new OpenFile(textArea, stage);
	    openItem.setOnAction(openAction);
	    root.setCenter(textArea);
	    
	    // Create MenuItems - saveItem
	    MenuItem saveItem = new MenuItem("Save File");
	    SaveFile saveAction = new SaveFile(textArea);
	    saveItem.setOnAction(saveAction);
	    
	    // Create MenuItems - exitItem
	    MenuItem exitItem = new MenuItem("Exit");
	    exitItem.setOnAction(actionEvent -> Platform.exit());
	    
	    // Create MenuItems - spellCheck
	    MenuItem spellCheck = new MenuItem("Spell Check");

 
	    // Add MenuItems to the Menus
	    fileMenu.getItems().addAll(openItem, saveItem, exitItem);
	    editMenu.getItems().addAll(spellCheck);
	    
	    // get the menus to display on the screen 
	    menuBar.getMenus().addAll(fileMenu, editMenu);

	}
}

