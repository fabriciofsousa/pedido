package br.com.ecommerce.pedido.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CartaoUtil {

    public static boolean isCartaoCreditoValido(String numeroCartao) {
        // Regex para validar números de cartão de crédito
        String regex = "^(?:(?<visa>4[0-9]{12}(?:[0-9]{3})?)|"
                + "(?<mastercard>5[1-5][0-9]{14}))$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(numeroCartao);

        return matcher.matches();
    }
    public static String mascararCartaoCredito(String numeroCartao) {
        if (isCartaoCreditoValido(numeroCartao)) {
            // Mantém apenas os 4 últimos dígitos e mascara os anteriores
            int length = numeroCartao.length();
            String mascara = "************" + numeroCartao.substring(length - 4);
            return mascara;
        } else {
            // Se o número de cartão de crédito não for válido, retorne o mesmo número
            return numeroCartao;
        }
    }

}
