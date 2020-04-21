package Main.Builder;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.security.auth.login.LoginException;

import Main.Builder.Command.ServerInfo;
import Main.Builder.Command.testCommand;
import Main.Builder.JsonClasses.JsonParser;
import Main.Builder.JsonClasses.JsonWriter;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

public class Main extends JsonParser{
	public Main()throws FileNotFoundException {}


	private static String BOT = "TOKEN";
	private static String file = "C:\\Public\\Code\\code.json" ; 
	
	
	static JsonParser parser = new JsonParser();
	static JsonWriter write = new JsonWriter();
	@SuppressWarnings("static-access")
	static String token = parser.Parser(file, BOT);
	public static String getFile() {return file;}
	
	
    public static void main(String[] args) throws LoginException, IOException {
    	write.ResetFile();
    	
    	
        JDABuilder builder = new JDABuilder();
        builder.setToken(token);
        builder.setStatus(OnlineStatus.DO_NOT_DISTURB);
        builder.setActivity(Activity.playing("In a box"));
        builder.addEventListeners(new ServerInfo());
        builder.addEventListeners(new testCommand());
        
        
        
        
        
        
        
        
        
        
        builder.build();

    }
    
   


       
        

}