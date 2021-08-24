package br.com.ecommerce.mercadolivre.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private BigDecimal price;
    private Integer quantity;
    private String description;
    @ManyToOne
    private Category category;
    private Instant instantRegistration;

    public Product(String name, BigDecimal price, Integer quantity,
                   String description,
                   Category category) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.category = category;
        this.instantRegistration = Instant.now();
    }

    @Override
    public String toString() {
        return "Product{" +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", description='" + description + '\'' +
                ", category=" + category +
                '}';
    }
}
