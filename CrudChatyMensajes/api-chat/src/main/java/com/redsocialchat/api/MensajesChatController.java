package com.redsocialchat.api;

import com.redsocialchat.model.ChatDto;
import com.redsocialchat.model.MensajeDto;
import com.redsocialchat.model.RespuestaApi;
import com.redsocialchat.service.MensajesChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("chat/v1")
public class MensajesChatController {

    @Autowired
    private MensajesChatService mensajesChatService;



    @PostMapping("/chat")
    public ResponseEntity<Object> creaChat(@RequestBody ChatDto chat) {
        return new ResponseEntity<>(mensajesChatService.guardaChat(chat),HttpStatus.OK);
    }

    @GetMapping("/chats")
    public ResponseEntity<Object> mostrarChats() {
        return new ResponseEntity<>(mensajesChatService.mostrarallChats(),HttpStatus.OK);
    }

    @DeleteMapping("/chat")
    public ResponseEntity<Object> eliminaChat(@RequestBody ChatDto chat) {
        return new ResponseEntity<>(mensajesChatService.guardaChat(chat),HttpStatus.OK);
    }


    @PostMapping("/mensaje")
    public ResponseEntity<Object> creaMensaje(@RequestBody MensajeDto mensajeDto) {
        return new ResponseEntity<>(mensajesChatService.guardaMensaje(mensajeDto),HttpStatus.OK);
    }

    @GetMapping("/mensajesall")
    public ResponseEntity<Object> mostrarMensajes() {
        return new ResponseEntity<>(mensajesChatService.mostrarAllMensajesChat(),HttpStatus.OK);
    }

    @GetMapping("/mensajes")
    public ResponseEntity<Object> mostrarMensajeschat(MensajeDto mensajeDto) {
        return new ResponseEntity<>(mensajesChatService.mostrarAllMensajesChat(mensajeDto),HttpStatus.OK);
    }

    @PatchMapping("/mensaje")
    public ResponseEntity<Object> actualizarMensaje(@RequestBody MensajeDto mensajeDto) {
        return new ResponseEntity<>(mensajesChatService.actualizaMensaje(mensajeDto),HttpStatus.OK);
    }

    @DeleteMapping("/mensaje")
    public ResponseEntity<Object> eliminaMensaje(@RequestBody MensajeDto mensajeDto) {
        return new ResponseEntity<>(mensajesChatService.eliminaMensaje(mensajeDto),HttpStatus.OK);
    }

    @GetMapping("/chat/{idUsuarioOrigen}/{idUsuarioDestino}")
    public ResponseEntity<Object> mostrarchatUsuario(@PathVariable(value = "idUsuarioOrigen") int idUsuarioOrigen
            ,@PathVariable(value = "idUsuarioDestino") int idUsuarioDestino) {
        return new ResponseEntity<>(mensajesChatService.mostrarChat(idUsuarioOrigen,idUsuarioDestino),HttpStatus.OK);
    }

    @DeleteMapping("/chats/{idUsuarioOrigen}")
    public ResponseEntity<Object> eliminaChatUser(@PathVariable(value = "idUsuarioOrigen") int idUsuarioOrigen) {
        return new ResponseEntity<>(mensajesChatService.eliminaChatUser(idUsuarioOrigen),HttpStatus.OK);
    }




}
