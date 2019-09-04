package com.metacube.ead;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONObject; 
import org.json.simple.parser.*; 

import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.metacube.Connection.ConnectionProvider;
import com.metacube.dao.InventoryDao;
import com.metacube.pojo.Inventory;;

@Path("hello")
public class Store {
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String getMessage(String json) {
		
		JsonParser jsonParser = new	JsonParser();
		JsonElement jsonElement = null;
		try {
			jsonElement = jsonParser.parse(new FileReader("exp.json"));
		} catch (JsonIOException e) {
			e.printStackTrace();
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Inventory inventory = new Inventory();
		if(jsonElement.isJsonObject()) {
			JsonObject jsonObject = jsonElement.getAsJsonObject();
			inventory.setName(jsonObject.get("Name").getAsString());
			inventory.setQuantity(jsonObject.get("quantity").getAsInt());
		}
		InventoryDao inDao = new InventoryDao();
		String msg = inDao.setData(inventory);
		return msg;
	}
	
}
