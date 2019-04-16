package com.java4s.app.util;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class Publisher {
	
	public void publishMessage(String topic, String messageBody) throws Exception {

		String serverUrl = "ssl://54.87.107.31:8883";
		String messageString = messageBody;
		String topicName = topic;
		String caFilePath = "/home/ubuntu/certs/m2mqtt_ca.crt";
		String clientCrtFilePath = "/home/ubuntu/certs/m2mqtt_srv.crt";
		String clientKeyFilePath = "/home/ubuntu/certs/m2mqtt_srv.key";
		String password = "pana@123";
		
		MqttClient client = new MqttClient(serverUrl,  MqttClient.generateClientId());
		//client.setCallback(new MyCallback());
		MqttConnectOptions options = new MqttConnectOptions();
		options.setConnectionTimeout(60);
		options.setKeepAliveInterval(60);
		options.setSocketFactory(SslUtil.getSocketFactory(caFilePath, clientCrtFilePath, clientKeyFilePath, password));
		client.connect(options);
		MqttMessage message = new MqttMessage();
		message.setPayload(messageString.getBytes());
		client.publish(topicName, message);
		client.disconnect();
	}

}
