package Main.Builder.JsonClasses;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonParser {
	
	//Parses given file Name and string to search
	public static String Parser(String File,String code){
		 JSONParser parser = new JSONParser();
	        try {
	           Object obj = parser.parse(new FileReader(File));
	           JSONObject jsonObject = (JSONObject)obj;
	           String jsonCode = (String)jsonObject.get(code);
	           return jsonCode;
	        } catch(Exception e) {
	            e.printStackTrace();
	        }
	        
	        return null;
	    }
	

	}



