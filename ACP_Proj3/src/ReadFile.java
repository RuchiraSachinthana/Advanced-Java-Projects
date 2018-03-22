import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javafx.scene.control.TextArea;

public class ReadFile extends IOException{
	
	// add test area
    TextArea textArea = new TextArea();
	
	BufferedReader bufferReader;
	StringBuilder stringBuffer;
	
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
