package br.com.ecommerce.pedido.repository;

import br.com.ecommerce.pedido.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, String> {

    Optional<Pedido> findById(String id);

    void deleteById(String id);
}
