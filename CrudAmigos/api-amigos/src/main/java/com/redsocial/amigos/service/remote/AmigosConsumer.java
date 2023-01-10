package com.redsocial.amigos.service.remote;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.redsocial.amigos.RabbitConfigConsumer;
import com.redsocial.amigos.model.AmigosDto;
import com.redsocial.amigos.model.RespuestaApi;
import com.redsocial.amigos.service.AmigosService;


@Component
public class AmigosConsumer {

	public static final Logger logger = LoggerFactory.getLogger(AmigosConsumer.class);
	private Gson json = new Gson();
	private AmigosService amigosService;

	public AmigosConsumer(AmigosService amigosService) {
		this.amigosService = amigosService;
	}

	@RabbitListener(queues = RabbitConfigConsumer.QUEUE_RED_SOCIAL_AGREGA_AMIGO)
	public void listenerAgregaAmigos(Message message) {
		String body = new String(message.getBody());
		logger.info("---------------> eliminacion de chats" + body);

		AmigosDto dto = json.fromJson(body, AmigosDto.class);
		
		RespuestaApi rApi = amigosService.crearAmigo(dto);
	}
}