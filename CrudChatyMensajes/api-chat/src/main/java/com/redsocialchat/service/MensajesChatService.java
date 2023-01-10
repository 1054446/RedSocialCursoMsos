package com.redsocialchat.service;

import com.redsocialchat.model.ChatDto;
import com.redsocialchat.model.MensajeDto;
import com.redsocialchat.model.RespuestaApi;
import com.redsocialchat.repository.MensajesChatRepository;
import com.redsocialchat.repository.MensajesRepository;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MensajesChatService {

    @Autowired
    private MensajesChatRepository mensajesChatRepository;

    @Autowired
    private MensajesRepository mensajesRepository;

    public RespuestaApi guardaChat(ChatDto chatDto){
	    RespuestaApi respuestaApi= new RespuestaApi();
	    ChatDto chatDtoResult=mensajesChatRepository.save(chatDto);
	    respuestaApi.setResultado(chatDtoResult);
	    respuestaApi.setMensaje("Operacion exitosa");
	    return respuestaApi;
    }

    public RespuestaApi mostrarallChats(){
        RespuestaApi respuestaApi= new RespuestaApi();
        respuestaApi.setResultado(mensajesChatRepository.findAll());
        respuestaApi.setMensaje("Operacion exitosa");
        return respuestaApi;
    }

    public RespuestaApi mostrarChat(int idUsuarioOrigen,int idUsuarioDestino ){
        RespuestaApi respuestaApi= new RespuestaApi();
        respuestaApi.setResultado(mensajesChatRepository.findByChat(idUsuarioOrigen,idUsuarioDestino));
        respuestaApi.setMensaje("Operacion exitosa");
        return respuestaApi;
    }

    @Transactional
    public RespuestaApi eliminaChatUser(int idUsuarioOrigen){
        System.out.println("*************************------> Se esta eliminando un chat del usuario: "+idUsuarioOrigen);
        RespuestaApi respuestaApi= new RespuestaApi();
        mensajesChatRepository.deleteChatUser(idUsuarioOrigen);
        respuestaApi.setResultado("");
        respuestaApi.setMensaje("Operacion exitosa");
        return respuestaApi;
    }


    public RespuestaApi guardaMensaje(MensajeDto mensajeDto){
        RespuestaApi respuestaApi= new RespuestaApi();
        MensajeDto mensajeDtoRespuesta=mensajesRepository.save(mensajeDto);
        respuestaApi.setResultado(mensajeDtoRespuesta);
        respuestaApi.setMensaje("Operacion exitosa");
        return respuestaApi;
    }

    public RespuestaApi mostrarAllMensajesChat(){
        RespuestaApi respuestaApi= new RespuestaApi();
        respuestaApi.setResultado(mensajesChatRepository.findAll());
        respuestaApi.setMensaje("Operacion exitosa");
        return respuestaApi;
    }

    public RespuestaApi mostrarAllMensajesChat(MensajeDto mensajeDto){
        RespuestaApi respuestaApi= new RespuestaApi();
        respuestaApi.setResultado(mensajesChatRepository.findById(""+mensajeDto.getIdChat()));
        respuestaApi.setMensaje("Operacion exitosa");
        return respuestaApi;
    }

    public RespuestaApi eliminaMensaje(MensajeDto mensajeDto){
        RespuestaApi respuestaApi= new RespuestaApi();
        mensajesRepository.delete(mensajeDto);
        respuestaApi.setMensaje("Operacion exitosa");
        return respuestaApi;
    }

    public RespuestaApi actualizaMensaje(MensajeDto mensajeDto){
        RespuestaApi respuestaApi= new RespuestaApi();
        MensajeDto mensajeDtoRespuesta=mensajesRepository.save(mensajeDto);
        respuestaApi.setResultado(mensajeDtoRespuesta);
        respuestaApi.setMensaje("Operacion exitosa");
        return respuestaApi;
    }


}
