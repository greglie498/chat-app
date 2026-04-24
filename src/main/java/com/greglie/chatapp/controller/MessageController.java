package com.greglie.chatapp.controller;

import com.greglie.chatapp.entity.Message;
import com.greglie.chatapp.service.MessageService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/messages")
public class MessageController {
    private final MessageService messageService;
    
    public MessageController(MessageService messageService){
        this.messageService = messageService;
    }
    
    @PostMapping("/send")
    public Message sendMesage(@RequestBody Message message){
        System.out.println(">>> sendMessage HIT <<<");
       return messageService.sendMessage(message); 
    }
    
    @GetMapping("/chat")
    public ResponseEntity<List<Message>> getChat(
            @RequestParam Long user1,
            @RequestParam Long user2
    ) {
        return ResponseEntity.ok(
                messageService.getChat(user1, user2)
        );
    }
}
