import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Reflection {
	
	public ArrayList<String> analyzeFields(String className){
		List<String> fields = new ArrayList<>();
		try {
			Class c = Class.forName(className);
			Field f[] = c.getDeclaredFields();
			System.out.println("Fields: ");
			for(int i = 0; i < f.length; i++) {
				f[i] = c.getClass().getDeclaredField("setModel");
			}
			
		}
		catch(Throwable e){
			System.err.println(e);
		}
		
	}

}
