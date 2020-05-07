package Main.Builder.Command;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import Main.Builder.GlobalMsg;
import Main.Builder.JsonClasses.JsonParser;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Help extends ListenerAdapter{
	
	JSONArray commandList = new JSONArray();
	JsonParser jParse = new JsonParser();
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
		jArrayAddAliases(serverInfo);
		cInfo.put("Description", commandInfo);
		command.put("Help", cInfo);
		jParse.AddToJsonArray(command);
	}
	//Adds the String array to Json Array
	@SuppressWarnings("unchecked")
	private void jArrayAddAliases(String[] serverInfo) {

		for(String i : serverInfo) {
				jArray.add(i);
				
				
			}cInfo.put("Aliases", jArray);
		}
		
			
	public void onGuildMessageReceived(GuildMessageReceivedEvent event){
			
			
			
			String args  = event.getMessage().getContentRaw();
			boolean isCmdMsg = gMsg.checkCall(args,serverInfo,prefix,event);
			
			
			if(isCmdMsg) {
				JSONArray commands = jParse.ReadCommandList();
				int numOfCommands = commands.size();
				
			}
			
		}
	



}
