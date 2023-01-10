package com.redsocial.usuarios.service.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "mensajes-chats-microservicio", url = "mensajes-chats-microservicio:8280",fallback=ChatMensajesServiceClientFallback.class)
public interface ChatsMensajesServiceRemote {


    @RequestMapping(method = RequestMethod.DELETE,value = "cursomso/redsocial/v1/chats/{idUsuarioOrigen}",produces = "application/json")
    Object eliminaChatUser(@PathVariable(value = "idUsuarioOrigen") int idUsuarioOrigen);


}
