package br.com.ecommerce.pedido.util.constraints;

import br.com.ecommerce.pedido.Enum.StatusPagamento;
import br.com.ecommerce.pedido.Enum.TipoDePagamento;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.stream.Collectors;

public class TipoDePagamentoValidator implements ConstraintValidator<ValidTipoDePagamento, String> {

    @Override
    public void initialize(ValidTipoDePagamento constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        try {
            TipoDePagamento tipoDePagamento = TipoDePagamento.valueOf(value);
            return true;
        } catch (IllegalArgumentException e) {
            String validTypes = Arrays.stream(TipoDePagamento.values())
                    .map(Enum::name)
                    .collect(Collectors.joining(", "));

            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(
                    "Tipo de pagamento inválido. Tipos válidos: " + validTypes
            ).addConstraintViolation();
            return false;
        }
    }
}
