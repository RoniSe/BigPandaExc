package Models;

import java.util.Iterator;

import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.jongo.MongoCursor;
import org.bson.types.ObjectId;

import com.fasterxml.jackson.databind.JsonNode;
import com.mongodb.DB;
import com.mongodb.MongoClient;

public class dbAccess  {
	

	public static MongoCollection getColl(){ 
		try{
			 MongoClient mongo = new MongoClient("127.0.0.1", 27017);
			 DB db = mongo.getDB("Exc");
			 Jongo jongo = new Jongo(db);
			 return jongo.getCollection("messages");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return null;
   		}
	}
	
	public static MongoCursor<JsonNode> getAllMessages(){
		return getColl().find().projection("{_id:0}").as(JsonNode.class);
	}
	
}
 