package com.redsocial.amigos.api;

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

import com.redsocial.amigos.model.AmigosDto;
import com.redsocial.amigos.service.AmigosService;

@RestController
@RequestMapping("amigos/v1")
public class AmigosController {

	
	@Autowired
	private AmigosService amigosService;
	
	@PostMapping("/guardar")
    public ResponseEntity<Object> crearAmigo(@RequestBody AmigosDto amigosDto) {
		
        return new ResponseEntity<>(amigosService.crearAmigo(amigosDto),HttpStatus.OK);
    }

    @GetMapping("/obtener/{idUsuarioOrigen}")
    public ResponseEntity<Object> obtenerAmigos(@PathVariable(value="idUsuarioOrigen") int idUsuarioOrigen) {
    	
        return new ResponseEntity<>(amigosService.obtenerAmigos(idUsuarioOrigen),HttpStatus.OK);
    }

    @PatchMapping("/actualizar")
    public ResponseEntity<Object> actualizaAmigo(@RequestBody AmigosDto amigosDto) {
    	
        return new ResponseEntity<>(amigosService.actualizaAmigo(amigosDto),HttpStatus.OK);
    }

    @DeleteMapping("/baja")
    public ResponseEntity<Object> eliminaAmigo(@RequestBody AmigosDto amigosDto) {
    	
        return new ResponseEntity<>(amigosService.eliminaAmigo(amigosDto),HttpStatus.OK);
    }

}
