package br.com.ecommerce.mercadolivre.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
public class Profile implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String profile;

    public Profile(String profile) {
        this.profile = profile;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String getAuthority() {
        return this.profile;
    }

}
