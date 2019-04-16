package com.java4s.app.controller;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.java4s.app.util.Publisher;
import com.java4s.app.util.ReadFromMongo;
import com.java4s.model.MQTTMessage;

@RestController
public class SpringJava4sController {

	@PostMapping(path="/publish")
	public String customerInformation(@RequestBody MQTTMessage mqttMessage) 
	{

		Publisher publisher = new Publisher();
		int deviceNo = mqttMessage.getDeviceNo();
		String topicName = mqttMessage.getTopicName();
		String message = mqttMessage.getMessage();
		
		try {
			publisher.publishMessage(topicName, message);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return "Message published successfully ::: Device No: "+ deviceNo + ", Topic Name: " + topicName + ", Message: " + message;
	}
	
	@GetMapping(path="/getValue/{fieldName}")
	public String customerInformation(@PathVariable String fieldName) 
	{
		ReadFromMongo readFromMongo = new ReadFromMongo();
		String fieldDetails = readFromMongo.getFieldValue(fieldName);
		return fieldDetails;
	}
}

