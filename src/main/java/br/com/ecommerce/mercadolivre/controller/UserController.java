package br.com.ecommerce.mercadolivre.controller;

import br.com.ecommerce.mercadolivre.config.validation.UniqueEmailValidator;
import br.com.ecommerce.mercadolivre.controller.request.UserRequest;
import br.com.ecommerce.mercadolivre.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/login")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    private UserRepository userRepository;
    private UniqueEmailValidator uniqueEmailValidator;

    @Autowired
    public UserController(UserRepository userRepository, UniqueEmailValidator uniqueEmailValidator) {
        this.userRepository = userRepository;
        this.uniqueEmailValidator = uniqueEmailValidator;
    }

    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(uniqueEmailValidator);
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
