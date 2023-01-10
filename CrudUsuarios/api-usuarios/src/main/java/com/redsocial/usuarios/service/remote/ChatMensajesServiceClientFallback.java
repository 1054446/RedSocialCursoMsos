package com.redsocial.usuarios.service.remote;

import org.springframework.stereotype.Component;

@Component
public class ChatMensajesServiceClientFallback implements ChatsMensajesServiceRemote {
    @Override
    public Object eliminaChatUser(int idUsuarioOrigen) {
        return "Ocurrio un problema a consumir el servicio";
    }
}
