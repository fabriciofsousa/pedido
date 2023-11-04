package br.com.ecommerce.pedido.util.constraints;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CartaoCreditoValidator.class)
public @interface ValidCartaoCredito {
    String message() default "Número de cartão de crédito inválido";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}