package uis.edu.entorno.tienda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uis.edu.entorno.tienda.entity.Proveedor;
import uis.edu.entorno.tienda.repository.ProveedorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedorServiceImpl implements IProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Override
    public List<Proveedor> findAll() {
        return proveedorRepository.findAll();
    }

    @Override
    public Proveedor findById(Integer id) {
        return proveedorRepository.findById(id).orElse(null);
    }

    @Override
    public Proveedor save(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    @Override
    public void delete(Integer id) {
        proveedorRepository.deleteById(id);
    }

    @Override
    public Proveedor update(Integer id, Proveedor proveedor) {
        Optional<Proveedor> proveedorExistente = proveedorRepository.findById(id);
        if (proveedorExistente.isPresent()) {
            proveedor.setId(id); // Aseguramos el ID correcto
            return proveedorRepository.save(proveedor);
        }
        return null; // Devolvemos null si no se encuentra
    }
}