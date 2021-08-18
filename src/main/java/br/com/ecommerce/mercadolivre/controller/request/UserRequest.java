package br.com.ecommerce.mercadolivre.controller.request;

import br.com.ecommerce.mercadolivre.model.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserRequest {

    @NotBlank
    @JsonProperty("login")
    @Email
    private String login;

    @NotBlank
    @JsonProperty("senha")
    @Size(min = 6)
    private String senha;

    @Deprecated
    public UserRequest() {
    }

    public User toModel() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return new User(this.login, encoder.encode(this.senha));
    }

    public UsernamePasswordAuthenticationToken convert() {
        return new UsernamePasswordAuthenticationToken(login, senha);
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }


    @Override
    public String toString() {
        return "UserRequest{" +
                "login='" + login + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
