package com.spring.kafka.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.kafka.service.KafkaProducer;

@RestController
@RequestMapping("/kafka")
public class MainController {
	
	private KafkaProducer kafkaProducer;

	public MainController(KafkaProducer kafkaProducer) {
		super();
		this.kafkaProducer = kafkaProducer;
	}

	@GetMapping("/publish")
	public ResponseEntity<String> publish(@RequestParam("message")String message){
		kafkaProducer.sendMessage(message);
		return ResponseEntity.ok("Message sent to the topic");
	}

}
