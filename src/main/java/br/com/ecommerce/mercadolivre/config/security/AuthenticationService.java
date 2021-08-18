package br.com.ecommerce.mercadolivre.config.security;

import br.com.ecommerce.mercadolivre.model.User;
import br.com.ecommerce.mercadolivre.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuthenticationService implements UserDetailsService {

    private UserRepository repository;
    @Autowired
    public AuthenticationService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = repository.findByLogin(username);
        if(user.isPresent()){
            return user.get();
        }
        throw new UsernameNotFoundException("Dados inválidos");
    }
}
