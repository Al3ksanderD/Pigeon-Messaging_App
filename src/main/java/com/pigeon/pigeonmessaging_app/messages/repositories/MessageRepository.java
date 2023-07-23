package com.pigeon.pigeonmessaging_app.messages.repositories;

import com.pigeon.pigeonmessaging_app.messages.entities.MessageEntity;
import com.pigeon.pigeonmessaging_app.users.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<MessageEntity, Long> {
    @Query("SELECT DISTINCT e from MessageEntity e LEFT JOIN FETCH e.author WHERE e.author.id = :userID" )
    List<MessageEntity> findAllByCompany(Long userID);

}
