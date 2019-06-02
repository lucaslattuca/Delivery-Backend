package ml.work.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository;

import ml.work.main.entities.Factura;

@Repository
public interface FacturaRepository extends JpaRepository<Factura,Integer>{
}
