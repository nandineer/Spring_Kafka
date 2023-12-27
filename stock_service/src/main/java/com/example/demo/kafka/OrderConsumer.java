package com.example.demo.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.demo.dto.OrderEvent;

@Service
public class OrderConsumer {
	
	@KafkaListener(topics="${spring.kafka.topic.name}",groupId="${spring.kafka.consumer.group-id}")
	public void consume(OrderEvent orderEvent) {
		System.out.println("Order Consumer Event::"+orderEvent.toString());
		
		// save the event to the DB
	}

}
