package com.example.demo.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.OrderEvent;

@Service
public class OrderProducer {
	
	private NewTopic topic;
	
	
	private KafkaTemplate<String, OrderEvent> kafkaTemplate;


	public OrderProducer(NewTopic topic, KafkaTemplate<String, OrderEvent> kafkaTemplate) {
		super();
		this.topic = topic;
		this.kafkaTemplate = kafkaTemplate;
	}
	
	
	public void sendMessage(OrderEvent orderEvent) {
		
		System.out.println("Order Event:::::::::"+orderEvent.toString());
		Message<OrderEvent> message = MessageBuilder.withPayload(orderEvent)
				.setHeader(KafkaHeaders.TOPIC, topic.name())
				.build();
		kafkaTemplate.send(message);
	}

}
