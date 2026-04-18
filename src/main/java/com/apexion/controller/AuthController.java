package com.apexion.controller;

import com.apexion.model.User;
import com.apexion.repository.UserRepository;
import com.apexion.response.SignupRequest;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository userRepository;

    @PostMapping("/signup")
    public ResponseEntity<User> createUserHandler(@RequestBody SignupRequest req) {

        User user = new User();
        user.setEmail(req.getEmail());
        user.setFirstName(req.getFirstName());
        user.setLastName(req.getLastName());

        User savedUser = userRepository.save(user);

        return ResponseEntity.ok(savedUser);
    }
}