package com.redsocialchat.service.remote;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.redsocialchat.model.MensajeDto;
import com.redsocialchat.model.RespuestaApi;
import com.redsocialchat.model.UsuarioDto;
import com.redsocialchat.service.MensajesChatService;
import com.redsocialchat.service.RabbitConfigConsumer;

@Component
public class MensajesConsumer {

	public static final Logger logger = LoggerFactory.getLogger(MensajesConsumer.class);
	private Gson json = new Gson();
	private MensajesChatService mensajesChatService;

	public MensajesConsumer(MensajesChatService mensajesChatService) {
		this.mensajesChatService = mensajesChatService;
	}

	@RabbitListener(queues = RabbitConfigConsumer.QUEUE_RED_SOCIAL_ELIMINA_CHATS)
	public void listenerEliminaChats(Message message) {
		String body = new String(message.getBody());
		logger.info("------------> eliminar chats" + body);

		UsuarioDto dto = json.fromJson(body, UsuarioDto.class);

		RespuestaApi rApi = mensajesChatService.eliminaChatUser(dto.getIdUsuario());
	}
}