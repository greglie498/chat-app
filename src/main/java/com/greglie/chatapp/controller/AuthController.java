package com.greglie.chatapp.controller;

import com.greglie.chatapp.entity.User;
import com.greglie.chatapp.repository.UserRepository;
import com.greglie.chatapp.security.JwtUtil;
import java.util.Map;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/auth")
public class AuthController {
    
    private final UserRepository userRepo;
    private final BCryptPasswordEncoder encoder;
    
    public AuthController(UserRepository userRepo, BCryptPasswordEncoder encoder){
        this.userRepo = userRepo;
        this.encoder = encoder;
    }
    
    @PostMapping("/register")
    public String register (@RequestBody User user){
        user.setPassword(encoder.encode(user.getPassword()));
        userRepo.save(user);
        return "User registered successfully";
    }
    
    @PostMapping("/login")
    public Map<String, String> login(@RequestBody User loginData){
        User user = userRepo.findByUsername(loginData.getUsername())
                .orElseThrow(()-> new RuntimeException("User not found"));
                
        if (!encoder.matches(loginData.getPassword(), user.getPassword())){
            throw new RuntimeException ("Invalid credentials");
        }
        
        String token = JwtUtil.generateToken(user.getUsername());
        return Map.of("token", token);
    }
    
}
