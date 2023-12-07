package tn.esprit.backend.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.backend.Dto.CredentialsDto;
import tn.esprit.backend.Dto.SignUpDto;
import tn.esprit.backend.Dto.UserDto;
import tn.esprit.backend.config.UserAuthProvider;
import tn.esprit.backend.entities.ResetPasswordToken;
import tn.esprit.backend.entities.Role;
import tn.esprit.backend.services.PasswordResetService;
import tn.esprit.backend.services.UserService;

import java.net.URI;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final UserAuthProvider userAuthProvider;
    private final PasswordResetService passwordResetService;
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

    @PostMapping("/initiate")
    public ResponseEntity<ResetPasswordToken> initiatePasswordReset(@RequestBody Map<String, String> requestBody) {
        String email = requestBody.get("login");
        String token = requestBody.get("token");
        passwordResetService.initiatePasswordReset(email);

        return ResponseEntity.ok(passwordResetService.initiatePasswordReset(email));
    }
    @PostMapping("/confirm")
    public ResponseEntity<Void> confirmResetPassword(@RequestBody Map<String, String> requestBody) {
        String token = requestBody.get("token");
        String Password = requestBody.get("password");
        boolean success = passwordResetService.confirmPasswordReset(token,Password);

        if (success) {
            return ResponseEntity.ok().build();
        } else {
            // Token is invalid or expired
            return ResponseEntity.badRequest().build();
        }
    }
    }


