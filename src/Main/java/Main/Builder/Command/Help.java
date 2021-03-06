package Main.Builder.Command;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import Main.Builder.GlobalMsg;
import Main.Builder.JsonClasses.JsonWriter;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Help extends ListenerAdapter{
	
	JSONArray commandList = new JSONArray();
	JsonWriter jWrite = new JsonWriter();
	JSONObject cInfo = new JSONObject();
	JSONObject command = new JSONObject();
	JSONArray jArray = new JSONArray();
	Prefix serverPrefix = new Prefix();
	String prefix = serverPrefix.getPrefix();
	GlobalMsg gMsg = new GlobalMsg();
	
	//Command Values
	private final String[] serverInfo = {"Help","H"};
	private final String commandInfo = "Displays list of commands for Nezuko Bot";
	
	@SuppressWarnings("unchecked")
	public Help() {
		System.out.println("ran");
		jArrayAddAliases(serverInfo);
		cInfo.put("Description", commandInfo);
		command.put("Help", cInfo);
		jWrite.AddToJsonArray(command);
	}
	//Adds the String array to Json Array
	@SuppressWarnings("unchecked")
	private void jArrayAddAliases(String[] serverInfo) {

		for(String i : serverInfo) {
				jArray.add(i);
				
				
			}cInfo.put("Aliases", jArray);
		}
		
			
	
	



}
