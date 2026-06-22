package uz.antisocial.kun.uz.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.antisocial.kun.uz.dto.auth.AuthorizationDTO;
import uz.antisocial.kun.uz.dto.auth.RegistrationDTO;
import uz.antisocial.kun.uz.dto.auth.VerificationBySmsDTO;
import uz.antisocial.kun.uz.dto.profile.ProfileDTO;
import uz.antisocial.kun.uz.service.AuthService;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/registration")
    public ResponseEntity<String> registration(@Valid @RequestBody RegistrationDTO dto) {
        return ResponseEntity.ok(authService.registration(dto));
    }

    @GetMapping("/registration/email/verification/{token}")
    public ResponseEntity<String> registration(@PathVariable("token") String token) {
        return ResponseEntity.ok(authService.regEmailVerification(token));
    }

    @PutMapping("/registration/sms/verification")
    public ResponseEntity<String> verificationBySms(@RequestBody VerificationBySmsDTO dto) {
        return ResponseEntity.ok(authService.verificationBySms(dto));
    }

    @PostMapping("/login")
    public ResponseEntity<ProfileDTO> login(@Valid @RequestBody AuthorizationDTO dto) {
        return ResponseEntity.ok(authService.login(dto));
    }

}
