package com.greglie.chatapp.repository;

import com.greglie.chatapp.entity.Message;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MessageRepository extends JpaRepository<Message, Long> {
    
    List<Message> findBySenderIdAndReceiverId(
            Long senderId,
            Long receiverId
    );
}
