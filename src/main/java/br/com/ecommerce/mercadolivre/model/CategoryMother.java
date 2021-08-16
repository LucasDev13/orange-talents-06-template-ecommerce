package br.com.ecommerce.mercadolivre.model;

import javax.persistence.*;

@Entity
public class CategoryMother {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;

    @Deprecated
    public CategoryMother() {
    }
}
