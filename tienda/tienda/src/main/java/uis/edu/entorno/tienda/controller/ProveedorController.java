package uis.edu.entorno.tienda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uis.edu.entorno.tienda.entity.Proveedor;
import uis.edu.entorno.tienda.service.IProveedorService;

import java.util.List;

@RestController
@RequestMapping("/api/proveedores")
@CrossOrigin(origins = "*")
public class ProveedorController {

    @Autowired
    private IProveedorService proveedorService;

    // Endpoint para listar todos los proveedores
    @GetMapping
    public ResponseEntity<List<Proveedor>> listarProveedores() {
        return new ResponseEntity<>(proveedorService.findAll(), HttpStatus.OK);
    }

    // Endpoint para obtener un proveedor por ID
    @GetMapping("/{id}")
    public ResponseEntity<Proveedor> obtenerProveedorPorId(@PathVariable Integer id) {
        Proveedor proveedor = proveedorService.findById(id);
        if (proveedor != null) {
            return new ResponseEntity<>(proveedor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint para crear un nuevo proveedor
    @PostMapping
    public ResponseEntity<Proveedor> crearProveedor(@RequestBody Proveedor proveedor) {
        return new ResponseEntity<>(proveedorService.save(proveedor), HttpStatus.CREATED);
    }

    // Endpoint para actualizar un proveedor existente
    @PutMapping("/{id}")
    public ResponseEntity<Proveedor> actualizarProveedor(@PathVariable Integer id, @RequestBody Proveedor proveedor) {
        Proveedor proveedorActualizado = proveedorService.update(id, proveedor);
        if (proveedorActualizado != null) {
            return new ResponseEntity<>(proveedorActualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint para eliminar un proveedor
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProveedor(@PathVariable Integer id) {
        Proveedor proveedorExistente = proveedorService.findById(id);
        if (proveedorExistente != null) {
            proveedorService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}