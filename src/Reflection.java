import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Reflection {

	public ArrayList<String> getFields(String className, Log log) {

		String dataType; // String, boolean, etc
		String attributes; // make, model, etc

		// array to hold the data gathered
		// should come out like this:
		// [String, make, String, model, double, weight, double, engineSize, int,
		// numOfDoors, boolean, isImport]
		ArrayList<String> fields = new ArrayList<>();

		// get access to the class's fields
		try {
			Class c = Class.forName("Vehicle");
			Field f[] = c.getDeclaredFields();
			for (int i = 0; i < f.length - 3; i++) {
				dataType = f[i].getType().getName();
				attributes = f[i].toString();

				if (dataType.equals("java.lang.String")) {
					dataType = "String";
				}
				if (dataType.equalsIgnoreCase("string") || dataType.equalsIgnoreCase("int")
						|| dataType.equalsIgnoreCase("double") || dataType.equalsIgnoreCase("boolean")) {
					fields.add(dataType);
				}

				if (attributes.equals("private java.lang.String Vehicle.make")) {
					attributes = "make";
				}
				if (attributes.equals("private java.lang.String Vehicle.model")) {
					attributes = "model";
				}
				if (attributes.equals("private double Vehicle.weight")) {
					attributes = "weight";
				}
				if (attributes.equals("private double Vehicle.engineSize")) {
					attributes = "engineSize";
				}
				if (attributes.equals("private int Vehicle.numOfDoors")) {
					attributes = "numOfDoors";
				}
				if (attributes.equals("private boolean Vehicle.isImport")) {
					attributes = "isImport";
				}

				if (attributes.equalsIgnoreCase("make") || attributes.equalsIgnoreCase("model")
						|| attributes.equalsIgnoreCase("weight") || attributes.equalsIgnoreCase("numOfDoors")
						|| attributes.equalsIgnoreCase("engineSize") || attributes.equalsIgnoreCase("isImport")) {
					fields.add(attributes);
				}
			}
		} catch (Throwable e) {
			System.err.println(e);
		}
	//	System.out.println(fields);
		return fields;

	}
	
	//////////////////////////////////////////////////
	
	public ArrayList<String> getFieldValues(Object obj, Log log){
		String type;
		String field;
		String fieldValue = "";
		String className = obj.getClass().getName();
		ArrayList<String> instanceFields = getFields(className, log);
		ArrayList<String> instanceFieldValues = new ArrayList<String>();
		try {
			for (int index = 0; index < instanceFields.size()/2; index++) {
				type = instanceFields.get(index * 2);
				field = instanceFields.get(index * 2 + 1);

				Field privateField = obj.getClass().getDeclaredField(field);
				privateField.setAccessible(true);
			
				if (type.equalsIgnoreCase("String")) {
					fieldValue = (String) privateField.get(obj);
				}
				else if (type.equalsIgnoreCase("int")) {
					fieldValue = String.valueOf(privateField.get(obj));
				}
				else if (type.equalsIgnoreCase("double")) {
					fieldValue = String.valueOf(privateField.get(obj));
				}
				else if (type.equalsIgnoreCase("boolean")) {
					fieldValue = String.valueOf(privateField.get(obj));
				}
				instanceFieldValues.add(type);
				instanceFieldValues.add(fieldValue);
			}
		}
		catch (Throwable e) {
			System.err.println(e);
		} 
		return instanceFieldValues;
	}

}
