package com.redsocial.usuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.redsocial.usuarios.model.UsuarioDto;

@Repository
public interface UsuariosRepository extends JpaRepository<UsuarioDto, String>{

}
