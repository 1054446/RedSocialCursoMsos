package com.redsocial.usuarios.service.remote.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;


import com.google.gson.Gson;
import com.redsocial.usuarios.RabbitConfigConsumer;
import com.redsocial.usuarios.service.UsuariosServiceImpl;

@Component
public class AmigosProducer {
	
	public static final Logger logger = LoggerFactory.getLogger(AmigosProducer.class);
	private RabbitTemplate rabbitTemplate;
	private Gson json = new Gson();

	public AmigosProducer(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}
	
	public void sendAgregaAmigo(String contractEvent) {
		rabbitTemplate.convertAndSend(RabbitConfigConsumer.QUEUE_RED_SOCIAL_AGREGA_AMIGO, contractEvent);
		logger.info("----------------> agregando amigo");
	}
}
