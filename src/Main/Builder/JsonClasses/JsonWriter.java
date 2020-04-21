package Main.Builder.JsonClasses;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import Main.Builder.Main;

public class JsonWriter {
	JSONArray jArray = new JSONArray();
	
	private final String file = "C:\\Public\\Code\\Commands.json";
	

	//Writes Json Array to file 
	public void WriteToJson(JSONArray jArray)throws IOException {
		
		try(FileWriter Writer = new FileWriter(file)){
			Writer.write(jArray.toString());
			Writer.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	@SuppressWarnings("unchecked")
	public void AddToJsonArray(JSONObject command) {
		JSONParser parser = new JSONParser();
		JSONArray jsonObjects = new JSONArray();
		try {
	           Object obj = parser.parse(new FileReader(file));
	           jsonObjects = (JSONArray)obj;
	           jsonObjects.add(command);
	           WriteToJson(jsonObjects);
	           System.out.println("New array is " + jsonObjects.toString());
	          
	           
	           
	        } catch(Exception e) {
	            e.printStackTrace();
	        } 

	}
	public void ResetFile() {
		try(FileWriter Writer = new FileWriter(file)){
			Writer.write(jArray.toString());
			Writer.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
	
}
