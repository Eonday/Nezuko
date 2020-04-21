package Main.Builder.Command;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import Main.Builder.JsonClasses.JsonWriter;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Emote;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;



public class ServerInfo extends ListenerAdapter {

	
	//Objects
	JsonWriter jWrite = new JsonWriter();
	JSONObject cInfo = new JSONObject();
	JSONObject command = new JSONObject();
	JSONArray jArray = new JSONArray();
	Prefix serverPrefix = new Prefix();
	String prefix = serverPrefix.getPrefix();
		 
	//Command Values
	private final String[] serverInfo = {"ServerInfo","Sinfo"};
	private final String commandInfo = "Displays the info of the given server";
	private final String errorMsg = "```Incorrect Parameters```";
	
	//Constructor
	//
	@SuppressWarnings("unchecked")
	public ServerInfo() {
		jArrayAddAliases(serverInfo);
		cInfo.put("Description", commandInfo);
		command.put("ServerInfo", cInfo);
		jWrite.AddToJsonArray(command);
	}
	
	
	//Adds the String array to Json Array
	@SuppressWarnings("unchecked")
	private void jArrayAddAliases(String[] serverInfo) {

		for(String i : serverInfo) {
			jArray.add(i);
			
			
		}cInfo.put("Aliases", jArray);
	}
	
	//Checks if the user called the command correctly
	//else sends a error message
	private boolean checkCall(String args) {
		for(String i : serverInfo) {
			if(args.equalsIgnoreCase(prefix + i)) {
				return true;
			}
		}return false;
	}
	
	//Command Call
	public void onGuildMessageReceived(GuildMessageReceivedEvent event){
		
		
		String args  = event.getMessage().getContentRaw();
		
		
			if(checkCall(args)) {
				//object
				EmbedBuilder info = new EmbedBuilder();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				
				
				
				//Server Information
				List<Emote>emotes = event.getGuild().getEmoteCache().asList();
				List<String>serverEmotes = new ArrayList<>(Arrays.asList(""));
				String name  = event.getGuild().getName() ; //Server name
				String id = event.getGuild().getId(); // Server Id
				String owner = event.getGuild().getOwner().getEffectiveName(); //Server Owner
				String region = event.getGuild().getRegionRaw();  // Server Region
				String image = event.getGuild().getIconUrl();
				String date = event.getGuild().getTimeCreated().format(formatter); // Date of Server Creation
				String boost = Integer.toString(event.getGuild().getBoostCount()); //Server Amount of boost
				String members = Integer.toString(event.getGuild().getMembers().size());
				String textChannels = Integer.toString(event.getGuild().getTextChannels().size());
				String voiceChannels = Integer.toString(event.getGuild().getVoiceChannels().size());
				String roles = Integer.toString(event.getGuild().getRoles().size());
				String emoteSize = Integer.toString(event.getGuild().getEmotes().size());
				int incr = 0;
				for(Emote emote : emotes) {
					
					if( incr < 19) {
						String e = emote.getAsMention();
						serverEmotes.add(e);
						incr++;
					}else {
						break;
					}
				}
				String emotesList = String.join("", serverEmotes);
				
				
				//embed builder
				info.setColor(0x242FD4);
				info.setTitle(name);
				info.setThumbnail(image);
				info.setAuthor("Server");
				info.addField("ID",id,true);
				info.addField("Owner",owner,true);
				info.addField("Member Count",members,true);
				info.addField("Date Created",date, true);
				info.addField("Region",region,true);
				info.addField("Nitro Boost",boost,true);
				info.addField("Text Channels",textChannels,true);
				info.addField("Voice Channels", voiceChannels,true);
				info.addField("Roles", roles, true);
				info.addField("Emotes(" + emoteSize + ")", emotesList, true);
				event.getChannel().sendMessage(info.build()).queue();
				info.clear();
				

			}else if ( !checkCall(args) && !event.getAuthor().isBot() && args.startsWith(prefix) ) {
				event.getChannel().sendMessage(errorMsg).queue();}

	}

}
