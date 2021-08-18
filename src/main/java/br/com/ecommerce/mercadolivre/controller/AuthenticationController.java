package br.com.ecommerce.mercadolivre.controller;

import br.com.ecommerce.mercadolivre.config.token.GenerateToken;
import br.com.ecommerce.mercadolivre.controller.request.UserRequest;
import br.com.ecommerce.mercadolivre.controller.response.TokenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private GenerateToken generateToken;

    @PostMapping
    public ResponseEntity<?> authenticateToken(@RequestBody @Valid UserRequest request) {
        UsernamePasswordAuthenticationToken dataLogin = request.convert();
        try {
            Authentication authentication = authManager.authenticate(dataLogin);
            String token = generateToken.tokenGeneration(authentication);
            return ResponseEntity.ok(new TokenResponse(token, "Bearer"));
        }catch (AuthenticationException e){
            return ResponseEntity.badRequest().build();
        }
    }
}
