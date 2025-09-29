package uis.edu.entorno.tienda.service;

import uis.edu.entorno.tienda.entity.Proveedor;
import java.util.List;

public interface IProveedorService {

    List<Proveedor> findAll();

    Proveedor findById(Integer id);

    Proveedor save(Proveedor proveedor);

    void delete(Integer id);

    Proveedor update(Integer id, Proveedor proveedor);
}