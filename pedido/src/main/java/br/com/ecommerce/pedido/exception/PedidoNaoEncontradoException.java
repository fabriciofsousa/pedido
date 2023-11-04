package br.com.ecommerce.pedido.exception;

public class PedidoNaoEncontradoException extends RuntimeException {

    public PedidoNaoEncontradoException(String message) {
        super(message);
    }
}

