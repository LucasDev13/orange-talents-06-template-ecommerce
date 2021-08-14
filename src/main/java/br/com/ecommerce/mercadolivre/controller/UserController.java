package br.com.ecommerce.mercadolivre.controller;

import br.com.ecommerce.mercadolivre.controller.request.UserRequest;
import br.com.ecommerce.mercadolivre.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired private UserRepository userRepository;

    @GetMapping
    public String test(){
        return "deu boa";
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> saveUser(@Valid @RequestBody UserRequest request){
        try{
            userRepository.save(request.toModel());
            return ResponseEntity.ok().build();
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }

    }
}
