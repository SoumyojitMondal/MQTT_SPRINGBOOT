package com.java4s.model;

public class MQTTMessage {

	private int deviceNo;
	private String topicName;
	private String message;
	
	public MQTTMessage() {
		
	}
	
	public MQTTMessage(int deviceNo, String topicName, String message) {
		this.deviceNo = deviceNo;
		this.topicName = topicName;
		this.message = message;
	}

	public int getDeviceNo() {
		return deviceNo;
	}

	public void setDeviceNo(int deviceNo) {
		this.deviceNo = deviceNo;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
}
