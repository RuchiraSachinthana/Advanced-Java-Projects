import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javafx.scene.control.TextArea;

/**
 * @author Keenal
 * COP 4027 Advanced Computer Programming
 * Project 3
 * 
 * This class does the action for opening the file and it will read the file so it can be used in OpenFile class to 
 * put it into a textArea. 
 */

public class ReadFile extends IOException{
	
	// add test area
    TextArea textArea = new TextArea();
	
	BufferedReader bufferReader;
	StringBuilder stringBuffer;
	
	// Open file to read from
	 public String readFile(File file) throws IOException {
		  
		 
		 stringBuffer = new StringBuilder();
		  bufferReader = null;

		  try {

		      bufferReader = new BufferedReader(new FileReader(file));
		       
		      String text;
		      while ((text = bufferReader.readLine()) != null) {
		          stringBuffer.append(text + "\n");
		      }

		  } catch (FileNotFoundException ex) {
			  System.out.println(ex.getMessage());
		  } finally
			{
			//	BufferedReader bufferReader = null;
				bufferReader.close();
			} 
		   

	//	 String text = "hello";
	//	 return text;
		  return stringBuffer.toString();
	}


}
