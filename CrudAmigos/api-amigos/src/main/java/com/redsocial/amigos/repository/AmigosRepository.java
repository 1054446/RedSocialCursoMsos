package com.redsocial.amigos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.redsocial.amigos.model.AmigosDto;

@Repository
public interface AmigosRepository extends JpaRepository<AmigosDto, String> {
	@Query(value="SELECT * FROM amigos a WHERE a.idusuarioorigen=?1", nativeQuery = true)
    List<AmigosDto> findByUser(int idUsuarioOrigen);
}
