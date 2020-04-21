package Main.Builder.Command;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;

import Main.Builder.JsonClasses.JsonWriter;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class testCommand extends ListenerAdapter{
	@SuppressWarnings("unchecked")
	public testCommand() {
		JSONObject json = new JSONObject();
		json.put("test", "test");
		
		JsonWriter write = new JsonWriter();
		write.AddToJsonArray(json);

	}
	

}
