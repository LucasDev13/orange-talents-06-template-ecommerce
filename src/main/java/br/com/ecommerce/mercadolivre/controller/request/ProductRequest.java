package br.com.ecommerce.mercadolivre.controller.request;

import br.com.ecommerce.mercadolivre.config.validation.ExistsId;
import br.com.ecommerce.mercadolivre.model.Category;
import br.com.ecommerce.mercadolivre.model.Characteristics;
import br.com.ecommerce.mercadolivre.model.Product;
import br.com.ecommerce.mercadolivre.repository.CategoryRepository;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductRequest {

    @NotBlank
    private String name;
    @NotNull @Positive
    private BigDecimal price;
    @NotNull @Positive
    private Integer quantity;
    @NotBlank @Size(max = 1000)
    private String description;
    @NotNull @Positive @ExistsId(domainClass = Category.class, fieldName = "id")
    private Long idCategory;

    public ProductRequest(String name, BigDecimal price, Integer quantity,
                   String description, Long idCategory) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.idCategory = idCategory;
    }

    public Product toModel(CategoryRepository categoryRepository){
        Category categoryId = categoryRepository.findById(idCategory).get();
        return new Product(this.name, this.price, this.quantity, this.description, categoryId);
    }

    @Override
    public String toString() {
        return "ProductRequest{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", description='" + description + '\'' +
                ", category=" + idCategory +
                '}';
    }
}
