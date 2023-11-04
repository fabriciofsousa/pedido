package br.com.ecommerce.pedido.controller;

import br.com.ecommerce.pedido.dto.request.PedidoRequestDTO;
import br.com.ecommerce.pedido.dto.response.ResponseDTO;
import br.com.ecommerce.pedido.model.Pedido;
import br.com.ecommerce.pedido.service.service.PedidoService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    @Operation(description = "Finalizar Pedido",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody())
    public Optional<ResponseDTO> finalizarPedido(@RequestBody @Valid PedidoRequestDTO pedido) {
        return  pedidoService.finalizarPedido(pedido);
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    @Operation(description = "Encontrar todos pedidos")
    public Optional<List<Pedido>> getAll() throws Exception {
        return pedidoService.getAll();
    }


    @GetMapping("{id}")
    @ResponseStatus(value = HttpStatus.OK)
    @Operation(description = "Encontrar pedidos por id")
    public Optional<ResponseDTO> findById(@PathVariable("id") String code) {
        return pedidoService.findById(code);
    }

    @PutMapping("{id}")
    @ResponseStatus(value = HttpStatus.OK)
    @Operation(description = "Atualizar pedido por ID")
    public Pedido update(@RequestBody PedidoRequestDTO pedido, @PathVariable("id") String id) throws Exception {
        return this.pedidoService.update(id, pedido);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(description = "Deletar pedido por ID")
    public ResponseEntity<Void> delete(@PathVariable("id") String id) {
        this.pedidoService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
