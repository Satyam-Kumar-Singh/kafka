package com.spring.kafka.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.spring.kafka.config.AppConstants;

@Service
public class KafkaProducer {

	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

	private KafkaTemplate<String, String> kafkaTemplate;

	
	
// constructor based dependency injection we can autowired kafkatemplate also ----^
	public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	public void sendMessage(String message) {
		LOGGER.info(String.format("message sent %s", message));
		this.kafkaTemplate.send(AppConstants.TOPIC_NAME, message);
	}

}
