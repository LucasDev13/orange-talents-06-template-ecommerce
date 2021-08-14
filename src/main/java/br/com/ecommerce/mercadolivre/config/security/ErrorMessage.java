package br.com.ecommerce.mercadolivre.config.security;

import java.util.Collection;

public class ErrorMessage {
    private Collection<String> message;
    public ErrorMessage(Collection<String> message) {
        this.message = message;
    }

    public Collection<String> getMessage() {
        return message;
    }
}
