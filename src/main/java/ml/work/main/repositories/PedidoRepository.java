package ml.work.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ml.work.main.entities.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido,Integer>{
}
