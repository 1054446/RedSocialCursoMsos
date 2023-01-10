package com.redsocialchat.repository;

import com.redsocialchat.model.ChatDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface MensajesChatRepository extends JpaRepository<ChatDto, String> {

    @Query(value="SELECT * FROM chats c WHERE c.idusuarioorigen=?1 and c.idusuariodestino=?2", nativeQuery = true)
    List<ChatDto> findByChat(int idUsuarioOrigen,int idUsuarioDestino);

    @Transactional
    @Modifying
    @Query(value="DELETE from chats c WHERE c.idusuarioorigen=?1", nativeQuery = true)
    void deleteChatUser(int idUsuarioOrigen);

}
