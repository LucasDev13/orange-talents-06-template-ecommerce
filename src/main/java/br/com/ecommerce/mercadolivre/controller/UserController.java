package br.com.ecommerce.mercadolivre.controller;

import br.com.ecommerce.mercadolivre.controller.request.UserRequest;
import br.com.ecommerce.mercadolivre.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "/login")
public class UserController {

    @Autowired private UserRepository userRepository;

    @GetMapping
    public String test(){
        return "deu boa";
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> saveUser(@Valid @RequestBody UserRequest request){
        if(request != null){
            userRepository.save(request.toModel());
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();

    }
}
