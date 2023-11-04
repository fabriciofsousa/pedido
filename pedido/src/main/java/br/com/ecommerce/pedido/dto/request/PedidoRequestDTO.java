package br.com.ecommerce.pedido.dto.request;

import br.com.ecommerce.pedido.util.constraints.CartaoCreditoValidator;
import br.com.ecommerce.pedido.util.constraints.ValidCartaoCredito;
import br.com.ecommerce.pedido.util.constraints.ValidTipoDePagamento;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PedidoRequestDTO {

    private String idCarrinho;
    private double valorTotal;
    @ValidCartaoCredito
    private String numeroCartao;
    @ValidTipoDePagamento private String tipo;
    private String dataValidadeCartao;
    private String codigoSeguranca;
    private String codigoBoleto;
    private String formaEntrega;
}
