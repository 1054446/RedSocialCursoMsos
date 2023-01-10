package com.redsocial.usuarios.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redsocial.usuarios.model.AmigoDtoPeticion;
import com.redsocial.usuarios.model.UsuarioDto;
import com.redsocial.usuarios.service.UsuariosService;

@RestController
@RequestMapping("usuario/v1")
public class UsuariosController {
	
	@Autowired
	private UsuariosService usuariosService;
	
	@PostMapping("/crear")
    public ResponseEntity<Object> creaUsuario(@RequestBody UsuarioDto usuarioDto) {
        return new ResponseEntity<>(usuariosService.crearUsuario(usuarioDto),HttpStatus.OK);
    }
	
	/*
	 * Consultar amigo en tabla usuarios y 
	 * despues consumimos endpoint con 
	 * rabbitMQ de agregar amigos del mso de amigos 
	 * */
	@GetMapping("/agregarAmigo/{idAmigoOrigen}/{idAmigoDestino}")
    public ResponseEntity<Object> agregarAmigo(
    		@PathVariable(value="idAmigoOrigen")int amigoOrigen,
    		@PathVariable(value="idAmigoDestino")int amigoDestino) {
		
        return new ResponseEntity<>(usuariosService.agregarAmigo(amigoOrigen, amigoDestino),HttpStatus.OK);
    }

    @GetMapping("/consulta")
    public ResponseEntity<Object> consultarUsuarios() {
        return new ResponseEntity<>(usuariosService.consultarUsuarios(),HttpStatus.OK);
    }
    @GetMapping("/consultaUsuario/{idUsuario}")
    public ResponseEntity<Object> consultarUsuario(@PathVariable(value="idUsuario")int idUsuario) {
        return new ResponseEntity<>(usuariosService.consultarUsuario(idUsuario) ,HttpStatus.OK);
    }

    @PatchMapping("/actualiza")
    public ResponseEntity<Object> actualizaUsuario(@RequestBody UsuarioDto usuarioDto) {
        return new ResponseEntity<>(usuariosService.actualizaUsuario(usuarioDto),HttpStatus.OK);
    }

    @DeleteMapping("/elimina")
    public ResponseEntity<Object> eliminaUsuario(@RequestBody UsuarioDto usuarioDto) {
        return new ResponseEntity<>(usuariosService.eliminaUsuario(usuarioDto),HttpStatus.OK);
    }

}
