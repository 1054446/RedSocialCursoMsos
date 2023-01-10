package com.redsocialchat.repository;

import com.redsocialchat.model.ChatDto;
import com.redsocialchat.model.MensajeDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MensajesRepository extends JpaRepository<MensajeDto, String> {

}
