package com.redsocial.amigos.service;

import com.redsocial.amigos.model.RespuestaApi;
import com.redsocial.amigos.model.AmigosDto;
import com.redsocial.amigos.repository.AmigosRepository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AmigosService {
	
	@Autowired
    private AmigosRepository amigosRepository;

	@Transactional
	public RespuestaApi crearAmigo(AmigosDto amigosDto) {
		RespuestaApi respuestaApi = new RespuestaApi();
		AmigosDto respuestaAmigos = amigosRepository.save(amigosDto);
		respuestaApi.setResultado(respuestaAmigos);
		respuestaApi.setMensaje("Operacion Exitosa");
		return respuestaApi;
	}

	public RespuestaApi obtenerAmigos(int idUsuarioOrigen) {
		RespuestaApi respuestaApi= new RespuestaApi();
        respuestaApi.setResultado(amigosRepository.findByUser(idUsuarioOrigen));
        respuestaApi.setMensaje("Operacion exitosa");
        return respuestaApi;
	}

	public RespuestaApi actualizaAmigo(AmigosDto amigosDto) {
		RespuestaApi respuestaApi = new RespuestaApi();
		respuestaApi.setResultado(amigosRepository.save(amigosDto));
		respuestaApi.setMensaje("Operacion Exitosa");
		return respuestaApi;
	}

	public RespuestaApi eliminaAmigo(AmigosDto amigosDto) {
		RespuestaApi respuestaApi = new RespuestaApi();
		amigosRepository.delete(amigosDto);
		respuestaApi.setMensaje("Operacion Exitosa");
		return respuestaApi;
	}

}
