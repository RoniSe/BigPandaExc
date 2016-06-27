package Models;

import org.jongo.marshall.jackson.oid.MongoId;
import org.jongo.marshall.jackson.oid.MongoObjectId;
import org.bson.types.ObjectId;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;


public class Message {
	private long timeStamp;
	private String email;
	private String content;
	
	 
	public Message(JsonNode msg) throws InvalidFormatException {
		this.email = msg.get("email").asText();
		this.content = msg.get("content").asText();
		this.timeStamp = msg.get("timeStamp").asLong();
	}
	public void save(){
		 dbAccess.getColl().save(this);
	}
	
}
