package com.pigeon.pigeonmessaging_app.messages.entities;

import com.pigeon.pigeonmessaging_app.users.entities.UserEntity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class MessageEntity {
    @SequenceGenerator(
            name = "message_sequence",
            sequenceName = "message_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "message_sequence"
    )
    private Long id;
    private String messageText;
    private LocalDateTime creationDate;
    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity author;


}
