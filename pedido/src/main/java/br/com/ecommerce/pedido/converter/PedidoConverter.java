package br.com.ecommerce.pedido.converter;

import br.com.ecommerce.pedido.Enum.StatusPagamento;
import br.com.ecommerce.pedido.Enum.StatusPedido;
import br.com.ecommerce.pedido.Enum.TipoDePagamento;
import br.com.ecommerce.pedido.dto.request.PedidoRequestDTO;
import br.com.ecommerce.pedido.dto.response.PedidoDTO;
import br.com.ecommerce.pedido.model.Pedido;
import br.com.ecommerce.pedido.util.CartaoUtil;

import java.util.Date;

public class PedidoConverter {

    public PedidoDTO convertToResponseDTO(Pedido pedido) {
        var pedidoDTO = new PedidoDTO();
        pedidoDTO.setId(pedido.getId());
        pedidoDTO.setIdCarrinho(pedido.getIdCarrinho());
        pedidoDTO.setTipo(pedido.getTipo());
        pedidoDTO.setDataTransacao(pedido.getDataTransacao());
        pedidoDTO.setStatusPedido(pedido.getStatusPedido());
        pedidoDTO.setStatusPagamento(pedido.getStatusPagamento());

        return pedidoDTO;
    }

    public Pedido criarPedido(PedidoRequestDTO pedidoRequest) {
        var pedido = new Pedido();
        pedido.setIdCarrinho(pedidoRequest.getIdCarrinho());
        pedido.setDataTransacao(new Date());
        pedido.setTipo(TipoDePagamento.valueOf(pedidoRequest.getTipo()));
        pedido.setCodigoBoleto(pedidoRequest.getCodigoBoleto());
        pedido.setCodigoSeguranca(pedidoRequest.getCodigoSeguranca());
        pedido.setStatusPagamento(StatusPagamento.PROCESSANDO);
        pedido.setStatusPedido(StatusPedido.EM_PROCESSAMENTO);
        pedido.setValorTotal(pedidoRequest.getValorTotal());
        pedido.setNumeroCartao(pedidoRequest.getNumeroCartao());
        pedido.setDataValidadeCartao(pedidoRequest.getDataValidadeCartao());
        pedido.setFormaEntrega(pedidoRequest.getFormaEntrega());

        return pedido;
    }

    public Pedido convertDTOToPedido(Pedido pedidoRequest) {
        var pedido = new Pedido();
        pedido.setIdCarrinho(pedidoRequest.getIdCarrinho());
        pedido.setDataTransacao(new Date());
        pedido.setTipo(TipoDePagamento.valueOf(pedidoRequest.getTipo().getDescricao()));
        pedido.setCodigoBoleto(pedidoRequest.getCodigoBoleto());
        pedido.setCodigoSeguranca(pedidoRequest.getCodigoSeguranca());
        pedido.setStatusPagamento(StatusPagamento.PROCESSANDO);
        pedido.setStatusPedido(StatusPedido.EM_PROCESSAMENTO);
        pedido.setValorTotal(pedidoRequest.getValorTotal());
        pedido.setNumeroCartao(CartaoUtil.mascararCartaoCredito(pedidoRequest.getNumeroCartao()));
        pedido.setDataValidadeCartao(pedidoRequest.getDataValidadeCartao());
        pedido.setFormaEntrega(pedidoRequest.getFormaEntrega());

        return pedido;
    }

}
