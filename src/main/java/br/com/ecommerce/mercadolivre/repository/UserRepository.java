package br.com.ecommerce.mercadolivre.repository;

import br.com.ecommerce.mercadolivre.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
