package Main.Builder;

import java.io.IOException;
import javax.security.auth.login.LoginException;

import Main.Builder.Command.Help;
import Main.Builder.Command.ServerInfo;
import Main.Builder.JsonClasses.JsonParser;
import Main.Builder.JsonClasses.JsonWriter;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

public class Nezuko extends JsonParser{
	
	
	static JsonParser parser = new JsonParser();
	static JsonWriter write = new JsonWriter();

	private static String BOT = "TOKEN";
	private static String codeFile = "C:\\Public\\Code\\code.json" ;
	public final String commandFile = "C:\\Public\\Code\\Commands.json"; 
	@SuppressWarnings("static-access")
	static String token = parser.Parser(codeFile, BOT);
	
	
	
	
	public String getCommandFile() {
		return commandFile;
	}
	
	public static String getFile() {return codeFile;}
	
	
	//Bot Startup
    public static void main(String[] args) throws LoginException, IOException {
    	write.ResetFile();
    	
    	
       
		@SuppressWarnings("deprecation")
		JDABuilder builder = new JDABuilder();
        builder.setToken(token);
        builder.setStatus(OnlineStatus.DO_NOT_DISTURB);
        builder.setActivity(Activity.playing("In a box"));
        builder.addEventListeners(new ServerInfo());
        builder.addEventListeners(new Help());
        
        
        
        
       
        
        
        
        
        
        
        builder.build();

    }
    
   


       
        

}