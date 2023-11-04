package br.com.ecommerce.pedido.dto.response;

import br.com.ecommerce.pedido.Enum.StatusPagamento;
import br.com.ecommerce.pedido.Enum.StatusPedido;
import br.com.ecommerce.pedido.Enum.TipoDePagamento;
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
public class PedidoDTO {
    private Long id;
    private String idCarrinho;
    private TipoDePagamento tipo;
    private Date dataTransacao;
    private StatusPagamento statusPagamento;
    private StatusPedido statusPedido;

}
