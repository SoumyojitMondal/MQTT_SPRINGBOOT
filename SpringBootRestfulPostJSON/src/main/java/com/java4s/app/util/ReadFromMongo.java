package com.java4s.app.util;

import java.net.UnknownHostException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

public class ReadFromMongo {
	
	public String getFieldValue(String fieldName) {
		MongoClient client;
		String output = "";
		String value = "";
		try {
			client = new MongoClient("54.221.117.25", 27017);
			DB database = client.getDB("panaDB");
			DBCollection collection = database.getCollection("iotData");
			BasicDBObject whereQuery = new BasicDBObject();
			whereQuery.put("TagName", fieldName);
			DBCursor cursor = collection.find(whereQuery);
			while (cursor.hasNext()) {
				output = output + cursor.next();
			}
			
			Object obj = new JSONParser().parse(output); 
	        JSONObject jo = (JSONObject) obj; 
		    value = (String) jo.get("Value");
		    
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}
}
