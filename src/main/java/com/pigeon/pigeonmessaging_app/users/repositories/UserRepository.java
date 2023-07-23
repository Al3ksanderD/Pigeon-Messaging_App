package com.pigeon.pigeonmessaging_app.users.repositories;

import com.pigeon.pigeonmessaging_app.users.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    @Query("SELECT d from UserEntity d LEFT JOIN FETCH d.messages WHERE d.id = :id")
    Optional<UserEntity> findOneByID(Long id);

    @Query("SELECT d from UserEntity d LEFT JOIN FETCH d.messages WHERE d.username = :name")
    Optional<UserEntity> findOneByUserName(String name);

    @Query("SELECT d from UserEntity d LEFT JOIN FETCH d.messages")
    List<UserEntity> findAllBy();
}
