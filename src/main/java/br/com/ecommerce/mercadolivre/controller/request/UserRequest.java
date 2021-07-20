package br.com.ecommerce.mercadolivre.controller.request;

import br.com.ecommerce.mercadolivre.model.User;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UserRequest {

    @NotBlank
    @Email
    private String login;
    @NotBlank
    private String senha;

    @Deprecated
    public UserRequest() {
    }

    public User toModel(){
        return new User(this.login, this.senha);
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
