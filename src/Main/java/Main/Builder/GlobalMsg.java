package Main.Builder;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class GlobalMsg {
	
	public final String errorMsgParam = "```Incorrect Parameters```";
	public final String errorMsgPerm = "```Incorrect Permissions```";
	
	public String getErrorMsgParam() {
		return errorMsgParam;
		
	}
	public String getErrorMsgPerm() {
		return errorMsgPerm;
		
	}
	
	public boolean checkCall(String args , String[] aliases,String serverPrefix,GuildMessageReceivedEvent event) {
	
		
		if(!event.getAuthor().isBot()&& args.startsWith(serverPrefix)) {
			
				for(String i : aliases) {			
					if(args.equalsIgnoreCase(serverPrefix + i ) ) {
						return true;
					}
			}event.getChannel().sendMessage(errorMsgParam).queue();
		}return false;
	}
		
	















}
