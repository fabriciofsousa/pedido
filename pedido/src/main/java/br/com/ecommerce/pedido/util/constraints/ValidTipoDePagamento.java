package br.com.ecommerce.pedido.util.constraints;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TipoDePagamentoValidator.class)
public @interface ValidTipoDePagamento {
    String message() default "Tipo de pagamento inválido. Tipos válidos: {validTypes}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
