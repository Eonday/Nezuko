package Main.Builder.JsonClasses;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;

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
	
	
	public void ResetFile() {
		try(FileWriter Writer = new FileWriter(file)){
			Writer.write(jArray.toString());
			Writer.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
	
}
