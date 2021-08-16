package br.com.ecommerce.mercadolivre.repository;

import br.com.ecommerce.mercadolivre.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
