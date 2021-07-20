package br.com.ecommerce.mercadolivre.model;

import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    @Size(min = 6)
    //A senha deve ser guardada usando algum algoritmo de hash da sua escolha.
    private String senha;
    @Column(nullable = false)
    private Instant acesso = Instant.now();

    public User(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }
}
