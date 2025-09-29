package uis.edu.entorno.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uis.edu.entorno.tienda.entity.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}
