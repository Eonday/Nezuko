package Mongo.db;


import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;



@SuppressWarnings("rawtypes")
public class DbaseParser {
	


	MongoClientURI uri = new MongoClientURI("mongodb://Eonday:Smite971@discordbot-shard-00-00-d8hml.mongodb.net:27017,discordbot-shard-00-01-d8hml.mongodb.net:27017,discordbot-shard-00-02-d8hml.mongodb.net:27017/test?replicaSet=DiscordBot-shard-0&ssl=true&authSource=admin");
	MongoClient mongoClient = new MongoClient(uri);
	
	
	MongoDatabase NezukoBot = mongoClient.getDatabase("Nezuko_Bot");
	MongoCollection Commands = NezukoBot.getCollection("Commands");
	
	@SuppressWarnings("unchecked")
	public void AddCommandToDB(Document commandDoc) {
//		String commandName = commandDoc.getString("CommandName");
		if(!CommandExist(commandDoc)) {
			Commands.insertOne(commandDoc);}
		}

	
	public boolean CommandExist(Document command){
		if(Commands.find(command) != null) {

			return true;
		}else  {return false;}
		
	}
	
	

	
	
	
		
		
		
		
		
		

}
