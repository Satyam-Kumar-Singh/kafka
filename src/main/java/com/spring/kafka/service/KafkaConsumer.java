package com.spring.kafka.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.spring.kafka.config.AppConstants;

@Service
public class KafkaConsumer {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(KafkaConsumer.class);
	
	@KafkaListener(topics=AppConstants.TOPIC_NAME,groupId = "myGroup")
	public void consume(String message) {
		LOGGER.info(String.format("message received -> %s", message));
	}
}
