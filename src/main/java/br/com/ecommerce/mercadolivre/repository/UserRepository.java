package br.com.ecommerce.mercadolivre.repository;

import br.com.ecommerce.mercadolivre.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByLogin(String login);
}
