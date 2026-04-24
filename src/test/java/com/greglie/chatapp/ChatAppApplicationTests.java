package com.greglie.chatapp;

import com.greglie.chatapp.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class ChatAppApplicationTests {

    @MockBean
    private UserRepository userRepository;

    @Test
    void contextLoads() {
        
    }
    }