


package com.redsocial.usuarios.service;

import com.google.gson.Gson;
import com.redsocial.usuarios.model.AmigoDtoPeticion;
import com.redsocial.usuarios.model.RespuestaApi;
import com.redsocial.usuarios.model.UsuarioDto;
import com.redsocial.usuarios.repository.UsuariosRepository;

import java.util.List;

import javax.transaction.Transactional;

import com.redsocial.usuarios.service.remote.async.AmigosProducer;
import com.redsocial.usuarios.service.remote.async.ChatsEliminacionProducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuariosServiceImpl implements UsuariosService{

    @Autowired
    private UsuariosRepository usuariosRepository;
    
    @Autowired
    private ChatsEliminacionProducer chatsEliminacionProducer;
    
    @Autowired
    private AmigosProducer amigosProducer;

	/*@Autowired
	private ChatsMensajesServiceRemote chatsMensajesServiceRemote;*/
	
    private Gson json = new Gson();

    @Override
	public RespuestaApi crearUsuario(UsuarioDto usuarioDto) {
		RespuestaApi respuestaApi = new RespuestaApi();
		UsuarioDto rspBd = usuariosRepository.save(usuarioDto);
		respuestaApi.setResultado(rspBd);
		respuestaApi.setMensaje("Operacion Exitosa");
		return respuestaApi;
	}

    @Override
	public RespuestaApi consultarUsuarios() {
		RespuestaApi respuestaApi = new RespuestaApi();
		respuestaApi.setResultado(usuariosRepository.findAll());
		respuestaApi.setMensaje("Operacion Exitosa");
		return respuestaApi;
	}

    @Override
	public RespuestaApi actualizaUsuario(UsuarioDto usuarioDto) {
		RespuestaApi respuestaApi = new RespuestaApi();
		respuestaApi.setResultado(usuariosRepository.save(usuarioDto));
		respuestaApi.setMensaje("Operacion Exitosa");
		return respuestaApi;
	}

	@Transactional
	@Override
	public RespuestaApi eliminaUsuario(UsuarioDto usuarioDto) {
		System.out.println("*************************------> Se esta eliminando el usuario: "+usuarioDto.getIdUsuario());
		RespuestaApi respuestaApi = new RespuestaApi();
		usuariosRepository.delete(usuarioDto);
		respuestaApi.setMensaje("Operacion Exitosa");
		//respuestaApi.setResultado(chatsMensajesServiceRemote.eliminaChatUser(usuarioDto.getIdUsuario()));

		chatsEliminacionProducer.sendDelete(json.toJson(usuarioDto));
		
		return respuestaApi;
	}
	
	@Override
	public RespuestaApi consultarUsuario(int idUsuario) {
		RespuestaApi respuestaApi = new RespuestaApi();
		UsuarioDto usuarioAmigo= buscarPorId(usuariosRepository.findAll(),idUsuario);
		
		if(usuarioAmigo != null) {
			respuestaApi.setResultado(usuarioAmigo);
			respuestaApi.setMensaje("Operacion Exitosa");
			return respuestaApi;
		}
		else{
			respuestaApi.setMensaje("No se encontro informacion");
			respuestaApi.setResultado(null);
			return respuestaApi;
		}
	}

	@Transactional
	@Override
	public RespuestaApi agregarAmigo(int idAmigoOrigen, int idAmigoDestino) {
		RespuestaApi rspConsulta = consultarUsuario(idAmigoDestino);
		
		if(rspConsulta.getResultado() != null) {
			AmigoDtoPeticion peticion = new AmigoDtoPeticion(0,
					idAmigoOrigen, 
					idAmigoDestino);
			amigosProducer.sendAgregaAmigo(json.toJson(peticion));
		}
		
		rspConsulta.setMensaje("Se agrego correctamente el amigo a la lista");
		return rspConsulta;
	}
	
	private UsuarioDto buscarPorId(List<UsuarioDto> lista, int id) {
		UsuarioDto userFind = lista.stream().filter( element -> element.getIdUsuario() == id).findFirst().orElse(null);
		return userFind;
	}


}
