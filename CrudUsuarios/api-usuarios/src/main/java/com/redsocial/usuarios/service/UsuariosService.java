package com.redsocial.usuarios.service;

import com.redsocial.usuarios.model.AmigoDtoPeticion;
import com.redsocial.usuarios.model.RespuestaApi;
import com.redsocial.usuarios.model.UsuarioDto;

public interface UsuariosService {
	RespuestaApi crearUsuario(UsuarioDto usuarioDto);
	RespuestaApi consultarUsuarios();
	RespuestaApi consultarUsuario(int idUsuario);
	RespuestaApi actualizaUsuario(UsuarioDto usuarioDto);
	RespuestaApi agregarAmigo(int idAmigoOrigen, int idAmigoDestino);
	RespuestaApi eliminaUsuario(UsuarioDto usuarioDto);
}
