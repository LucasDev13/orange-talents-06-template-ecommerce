package br.com.ecommerce.mercadolivre.model;

import javax.persistence.*;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    @ManyToOne
    private Category categoryMother;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Deprecated
    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    public void setCategoryMother(Category category) {
        this.categoryMother = category;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", categoryMother=" + categoryMother +
                '}';
    }
}
