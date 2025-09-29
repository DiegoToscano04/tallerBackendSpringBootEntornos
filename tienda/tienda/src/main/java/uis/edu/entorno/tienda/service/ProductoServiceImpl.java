package uis.edu.entorno.tienda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uis.edu.entorno.tienda.entity.Producto;
import uis.edu.entorno.tienda.repository.ProductoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements IProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    @Override
    public Producto findById(Integer id) {
        return productoRepository.findById(id).orElse(null);
    }

    @Override
    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Producto update(Integer id, Producto producto) {
        Optional<Producto> productoExistente = productoRepository.findById(id);
        if (productoExistente.isPresent()) {
            producto.setId(id); // Aseguramos que el ID sea el correcto para la actualización
            return productoRepository.save(producto);
        }
        return null; // El producto a actualizar no fue encontrado
    }

    @Override
    public void delete(Integer id) {
        productoRepository.deleteById(id);
    }
}