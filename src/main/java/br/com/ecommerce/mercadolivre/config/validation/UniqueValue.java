package br.com.ecommerce.mercadolivre.config.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {UniqueValueValidator.class})
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueValue {
    String message() default "valor duplicado";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload()default  { };
    //campo passado na anotação
    String fieldName();
    //campo passado na anotação
    Class<?> domainClass();
}
