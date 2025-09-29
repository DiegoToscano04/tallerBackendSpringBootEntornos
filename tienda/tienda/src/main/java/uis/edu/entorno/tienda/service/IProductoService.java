package uis.edu.entorno.tienda.service;

import uis.edu.entorno.tienda.entity.Producto;
import java.util.List;

public interface IProductoService {

    List<Producto> findAll();

    Producto findById(Integer id);

    Producto save(Producto producto);

    Producto update(Integer id, Producto producto);

    void delete(Integer id);
}