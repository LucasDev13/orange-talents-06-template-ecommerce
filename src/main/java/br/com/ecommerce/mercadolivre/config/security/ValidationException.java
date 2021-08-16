package br.com.ecommerce.mercadolivre.config.security;

public class ValidationException extends RuntimeException{

    private String message;

    public ValidationException(String message) {
        super(message);
    }
}
