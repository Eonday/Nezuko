package Main.Builder.Command;




import org.bson.Document;
import org.json.simple.JSONArray;


import com.mongodb.BasicDBObject;

import Main.Builder.GlobalMsg;
import Main.Builder.JsonClasses.JsonParser;
import Mongo.db.DbaseParser;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Help extends ListenerAdapter{
	
	//JSON Objects
	JSONArray commandList = new JSONArray();
	JsonParser jParse = new JsonParser();
	//MongoDb Objects
	BasicDBObject aliaseInfo = new BasicDBObject();
	BasicDBObject command = new BasicDBObject();
	Document newCommand = new Document();	
	//Class Objects
	Prefix serverPrefix = new Prefix();
	String prefix = serverPrefix.getPrefix();
	GlobalMsg gMsg = new GlobalMsg();
	DbaseParser mongo = new DbaseParser();
	
	//Command Values
	private final String[] serverInfo = {"Aliase1","Help","Aliase2","H"};
	private final String commandInfo = "Displays list of commands for Nezuko Bot";
	private final String commandName = "Help";
	
	

	//Constructor
	public Help() {
		SetUpObjects();
		newCommand.put(commandName, command);	
		mongo.AddCommandToDB(newCommand);			
	}
	
	//Sets up command object to be passed into the Db
	public void SetUpObjects() {
		//Cycles through all aliases in the array
		for(int i = 0 ; i < serverInfo.length ;i+=2) {
			aliaseInfo.put(serverInfo[i],serverInfo[i+1]);
		}
		
		command.put("Aliases",aliaseInfo);
		command.put("Description",commandInfo);
	}
			
	@SuppressWarnings("unused")
	public void onGuildMessageReceived(GuildMessageReceivedEvent event){
			
			
			
			String args  = event.getMessage().getContentRaw();
			boolean isCmdMsg = gMsg.checkCall(args,serverInfo,prefix,event);
			
			
			if(isCmdMsg) {
				JSONArray commands = jParse.ReadCommandList();
				int numOfCommands = commands.size();
				
			}
			
		}
	



}
