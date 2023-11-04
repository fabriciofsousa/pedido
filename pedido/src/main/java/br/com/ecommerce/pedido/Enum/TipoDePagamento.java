package br.com.ecommerce.pedido.Enum;

public enum TipoDePagamento {
    CARTAO_DE_CREDITO("Cartão de Crédito"),
    CARTAO_DE_DEBITO("Cartão de Débito"),
    BOLETO_BANCARIO("Boleto Bancário"),
    PIX("PIX"),
    PAYPAL("PayPal"),
    TRANSFERENCIA_BANCARIA("Transferência Bancária");

    private String descricao;

    TipoDePagamento(String descricao) {
        this.descricao = descricao;
    }


    public String getDescricao() {
        return descricao;
    }
}