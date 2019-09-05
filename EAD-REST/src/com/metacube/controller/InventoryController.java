package com.metacube.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.google.gson.Gson;
import com.metacube.enums.Status;
import com.metacube.facade.InventoryFacade;
import com.metacube.pojo.Inventory;
import com.metacube.util.Response;

@Path("/inventory")
public class InventoryController {
	InventoryFacade inventoryFacade = new InventoryFacade();
	
	@Path("/getAll")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllInventory() throws SQLException {
		Gson gson = new Gson();
		return gson.toJson(inventoryFacade.getAll());
	}
	
	@Path("/getName/{name}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getName(@PathParam("name") String name) throws SQLException {
		Gson gson = new Gson();
		return gson.toJson(inventoryFacade.getName(name));
	}
	
	@Path("/update/{name}")
	@PUT
	@Produces(MediaType.TEXT_HTML)
	public String updateQuantity(@PathParam("name") String name, String json) throws SQLException {
		Gson gson = new Gson();
		Inventory inventory = gson.fromJson(json, Inventory.class);
		Response response = new Response();
		if(inventoryFacade.updateAll(name, inventory) == Status.UPDATED) {
			response.setCode(200);
			response.setMessage("UPDATED");
			response.setStatus(true);
			return gson.toJson(response);
		}
		response.setCode(405);
		response.setMessage("NOT FOUND");
		response.setStatus(false);
		return gson.toJson(response);
	}
	
	@Path("/updateAll")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String updateAll(String json) throws SQLException, JsonParseException, JsonMappingException, IOException {
		Gson gson = new Gson();
		ObjectMapper mapper = new ObjectMapper();
		List<Inventory> inventoryList = Arrays.asList(mapper.readValue(json, Inventory[].class));
		Response response = new Response();
		for(Inventory obj : inventoryList) {
			if(inventoryFacade.update(obj.getName(), obj.getQuantity()) != Status.UPDATED) {
				response.setCode(405);
				response.setMessage("NOT UPDATED");
				response.setStatus(false);
				return gson.toJson(response);
			}
		}
		response.setCode(200);
		response.setMessage("UPDATED");
		response.setStatus(true);
		return gson.toJson(response);
	}
	
	@Path("/insert")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String insert(String json)throws Exception{
		Gson gson = new Gson();
		Inventory inventory_obj = gson.fromJson(json, Inventory.class);
		Response response = new Response();
		if(inventoryFacade.insert(inventory_obj.getName(), inventory_obj.getQuantity()) == Status.INSERTED){
			response.setCode(200);
			response.setMessage("Inserted");
			response.setStatus(true);
			return gson.toJson(response);
		}
		response.setCode(405);
		response.setMessage("NOT FOUND");
		response.setStatus(false);
		return gson.toJson(response);
	}
	
	@Path("/deleteall")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteallInventory() throws Exception{
		Gson gson = new Gson();
		Response response = new Response();
		if(inventoryFacade.deleteAll()==Status.DELETED){
			response.setCode(200);
			response.setMessage("DELETED");
			response.setStatus(true);
			return gson.toJson(response);
		}
		response.setCode(405);
		response.setMessage("NOT FOUND");
		response.setStatus(false);
		return gson.toJson(response);
	}
	
	@Path("/delete/{name}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteInventory(@javax.ws.rs.PathParam("name") String name) throws Exception{
		Gson gson = new Gson();
		Response response = new Response();
		if(inventoryFacade.delete(name)==Status.DELETED){
			response.setCode(200);
			response.setMessage("DELETED");
			response.setStatus(true);
			return gson.toJson(response);
		}
		response.setCode(405);
		response.setMessage("NOT FOUND");
		response.setStatus(false);
		return gson.toJson(response);
	}
	
	
	
}
