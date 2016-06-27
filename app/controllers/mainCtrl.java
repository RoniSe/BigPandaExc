package controllers;

import org.jongo.MongoCursor;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.fasterxml.jackson.databind.node.ArrayNode;

import Models.Message;
import Models.dbAccess;
import play.mvc.Controller;
import play.mvc.Result;

public class mainCtrl extends Controller{
	
	public static Result saveMsg(){
		Message msg;
		try {
			msg = new Message(request().body().asJson());
			msg.save();
			return ok();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
			return internalServerError(e.getMessage());
		}
		
		
	}
	
	public static Result getAllMessages(){
		ObjectMapper mapper = new ObjectMapper();
		ArrayNode msgArr = mapper.createArrayNode();
		MongoCursor<JsonNode> allMessages = dbAccess.getAllMessages();
		while(allMessages.hasNext()){
			msgArr.add(allMessages.next());
		}
		return ok(msgArr);
	}
}
