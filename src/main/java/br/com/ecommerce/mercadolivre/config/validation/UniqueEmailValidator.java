package br.com.ecommerce.mercadolivre.config.validation;

import br.com.ecommerce.mercadolivre.controller.request.UserRequest;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Component
public class UniqueEmailValidator implements Validator {

    @PersistenceContext
    EntityManager manager;

    @Override
    public boolean supports(Class<?> aClass) {
        return UserRequest.class.isAssignableFrom(aClass);
        //isAssignableFrom basicamente verifica se a referencia UserRequest.class é mãe ou igual a classe que está sendo passada no parâmetro
        //se não for vai retornar false e vai dar erro no processo de validação
    }

    @Override
    public void validate(Object o, Errors errors) {
        if (errors.hasErrors()){
            return;//interrrompe o fluxo se tiver algum erro.
        }
        UserRequest request = (UserRequest) o;
        Query queryUniqueEmail = manager.createQuery("select 1 from User u where u.login = :login")
                .setParameter("login", request.getLogin());
        List<?> resultList = queryUniqueEmail.getResultList();
        if(!resultList.isEmpty()){
            errors.rejectValue("login",null, "já existe este email no sistema.");
        }
    }
}
