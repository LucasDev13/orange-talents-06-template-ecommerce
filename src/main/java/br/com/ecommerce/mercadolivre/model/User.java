package br.com.ecommerce.mercadolivre.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.Instant;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    @Column(nullable = false, unique = true)
    private String login;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    private Instant acesso;

    public User(String login, String senha) {
        this.login = login;
        this.senha = senha;
        this.acesso = Instant.now();
    }
}
