package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import request.models.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
