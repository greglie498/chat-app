package com.greglie.chatapp.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "chats")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Chat {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
}
