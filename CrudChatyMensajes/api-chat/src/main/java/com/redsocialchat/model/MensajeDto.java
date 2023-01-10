package com.redsocialchat.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "mensajes", schema = "public")
public class MensajeDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idmensaje", updatable=false)
    private int idMensaje;
    @Column(name = "idchat")
    private int idChat;
    @Column(name = "fechahora")
    private Timestamp fechaHora;
    @Column(name = "texto")
    private String texto;
    @Column(name = "visto")
    private boolean visto;

    public MensajeDto() {
    }

    public int getIdMensaje() {
        return idMensaje;
    }

    public void setIdMensaje(int idMensaje) {
        this.idMensaje = idMensaje;
    }

    public int getIdChat() {
        return idChat;
    }

    public void setIdChat(int idChat) {
        this.idChat = idChat;
    }

    public Timestamp getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Timestamp fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public boolean isVisto() {
        return visto;
    }

    public void setVisto(boolean visto) {
        this.visto = visto;
    }
}
