package tn.esprit.backend.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.backend.Dto.CredentialsDto;
import tn.esprit.backend.Dto.SignUpDto;
import tn.esprit.backend.Dto.UserDto;
import tn.esprit.backend.config.UserAuthProvider;
import tn.esprit.backend.entities.Role;
import tn.esprit.backend.repositories.UserRespository;
import tn.esprit.backend.services.UserService;

import java.net.URI;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final UserAuthProvider userAuthProvider;
    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody CredentialsDto credentialsDto){
        UserDto user = userService.login(credentialsDto);
        user.setToken(userAuthProvider.createToken(user));
        return ResponseEntity.ok(user);
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody SignUpDto signUpDto){
     UserDto  user =   userService.register(signUpDto);
        user.setToken(userAuthProvider.createToken(user));
        user.setRole(Role.UNIVERSITY);
        return ResponseEntity.created(URI.create("/users/"+ user.getId())).body(user);
    }
}
