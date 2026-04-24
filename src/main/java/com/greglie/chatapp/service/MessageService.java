package com.greglie.chatapp.service;

import com.greglie.chatapp.entity.Message;
import com.greglie.chatapp.repository.MessageRepository;
import java.util.List;
import org.springframework.stereotype.Service;



@Service
public class MessageService {
    
    private final MessageRepository messageRepository;
    
    public MessageService(MessageRepository messageRepository){
        this.messageRepository = messageRepository;
    }
    
    public Message sendMessage (Message message){
       return messageRepository.save(message);
    }
    
    public List<Message> getChat(Long user1, Long user2){
        return messageRepository.findBySenderIdAndReceiverId(user1, user2);
    }
}
