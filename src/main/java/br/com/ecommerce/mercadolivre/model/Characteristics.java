package br.com.ecommerce.mercadolivre.model;

import javax.persistence.*;

@Entity
public class Characteristics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String description;

    public Characteristics(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
