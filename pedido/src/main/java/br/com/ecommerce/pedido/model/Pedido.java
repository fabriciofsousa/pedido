package br.com.ecommerce.pedido.model;

import br.com.ecommerce.pedido.Enum.StatusPagamento;
import br.com.ecommerce.pedido.Enum.StatusPedido;
import br.com.ecommerce.pedido.Enum.TipoDePagamento;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String idCarrinho;

    private TipoDePagamento tipo;

    @Column(nullable = false)
    private double valorTotal;

    @Column(nullable = false)
    private Date dataTransacao;

    @Column(nullable = false)
    private StatusPagamento statusPagamento;

    @Column(nullable = true)
    private String numeroCartao;

    @Column(nullable = true)
    private String dataValidadeCartao;

    @Column(nullable = true)
    private String codigoSeguranca;

    @Column(nullable = true)
    private String codigoBoleto;

    @Column(nullable = false)
    private String formaEntrega;

    @Column(nullable = false)
    private StatusPedido statusPedido;

}
