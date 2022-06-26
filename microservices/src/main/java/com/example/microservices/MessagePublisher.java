package com.example.microservices;

import java.util.Date;
import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessagePublisher {
	
	@Autowired
	private RabbitTemplate template;
	
	@PostMapping("/publish")
	public String publishMessage(@RequestBody CustomeMessage customeMessage) {
		customeMessage.setMessageId(UUID.randomUUID().toString());
		customeMessage.setMessageDate(new Date());
		template.convertAndSend(MQConfig.EXCHANGE,MQConfig.MESSAGE_ROUTING_KEY,customeMessage);
		
		return "MESSAGE PUBLISHED";
	}
}
