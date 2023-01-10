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
public class ChatsEliminacionProducer {
	
	/*
	 * La clase producer es la encargada de hacer la peticion al otro mso
	 * En el MSO de Chats debe de existir una clase que se llame Consumer
	 * Esta clase consumer debe de coincidir con los datos declarados en 
	 * el metodo que hace la peticion (sendDelete) 
	 * */

	public static final Logger logger = LoggerFactory.getLogger(ChatsEliminacionProducer.class);
	private RabbitTemplate rabbitTemplate;
	private Gson json = new Gson();

	public ChatsEliminacionProducer(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}
	
	public void sendDelete(String contractEvent) {
		rabbitTemplate.convertAndSend(RabbitConfigConsumer.QUEUE_RED_SOCIAL_ELIMINA_CHATS, contractEvent);
		logger.info("---------------------> eliminacion chats");
	}
}
