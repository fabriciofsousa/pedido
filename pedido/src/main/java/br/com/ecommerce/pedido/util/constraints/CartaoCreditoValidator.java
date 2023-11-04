package br.com.ecommerce.pedido.util.constraints;

import br.com.ecommerce.pedido.util.CartaoUtil;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CartaoCreditoValidator implements ConstraintValidator<ValidCartaoCredito, String> {

    @Override
    public void initialize(ValidCartaoCredito constraintAnnotation) {
    }

    @Override
    public boolean isValid(String numeroCartao, ConstraintValidatorContext context) {
        String numeroMascarado = CartaoCreditoValidator.mascararCartaoCredito(numeroCartao);

        return !numeroMascarado.equals(numeroCartao);
    }

    public static String mascararCartaoCredito(String numeroCartao) {
        return CartaoUtil.mascararCartaoCredito(numeroCartao);
    }
}