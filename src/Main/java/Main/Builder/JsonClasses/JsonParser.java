package Main.Builder.JsonClasses;

import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import Main.Builder.Nezuko;

public class JsonParser {
	
	//Objects
	JsonWriter write = new JsonWriter();
	Nezuko main = new Nezuko();
	
	
	String cmdFile = main.getCommandFile();
	
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
	
	
	@SuppressWarnings("unchecked")
	public void AddToJsonArray(JSONObject command) {
		JSONArray jsonObjects = new JSONArray();
		try {
	           jsonObjects = ReadCommandList();
	           jsonObjects.add(command);
	           write.WriteToJson(jsonObjects);
	        
	          
	           
	           
	        } catch(Exception e) {
	            e.printStackTrace();
	        } 

	}
	
	
	public JSONArray ReadCommandList() {
		JSONParser parser = new JSONParser();
		JSONArray jsonObjects = new JSONArray();
		try {
	           Object obj = parser.parse(new FileReader(cmdFile));
	           jsonObjects = (JSONArray)obj;
	           return jsonObjects;        
	        } catch(Exception e) {
	            e.printStackTrace();
	        } 
		return null ;
	}
	
	}



