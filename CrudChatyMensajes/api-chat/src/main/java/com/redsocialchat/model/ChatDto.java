package com.redsocialchat.model;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "chats", schema = "public")
public class ChatDto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idchat", updatable=false)
    private int idChat;
    @Column(name = "idusuarioorigen")
    private int idUsuarioOrigen;
    @Column(name = "idusuariodestino")
    private int idUsuarioDestino;

    public ChatDto() {
    }

    public int getIdChat() {
        return idChat;
    }

    public void setIdChat(int idChat) {
        this.idChat = idChat;
    }

    public int getIdUsuarioOrigen() {
        return idUsuarioOrigen;
    }

    public void setIdUsuarioOrigen(int idUsuarioOrigen) {
        this.idUsuarioOrigen = idUsuarioOrigen;
    }

    public int getIdUsuarioDestino() {
        return idUsuarioDestino;
    }

    public void setIdUsuarioDestino(int idUsuarioDestino) {
        this.idUsuarioDestino = idUsuarioDestino;
    }
}
