package uis.edu.entorno.tienda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uis.edu.entorno.tienda.entity.TipoDocumento;
import uis.edu.entorno.tienda.service.ITipoDocumentoService;
import java.util.List;
@RestController
@RequestMapping("/api/tipos-documento")
@CrossOrigin(origins = "*") // Opcional: permite peticiones desde cualquier origen
public class TipoDocumentoController {

    @Autowired
    private ITipoDocumentoService tipoDocumentoService;

    // Endpoint para listar todos los tipos de documento
    @GetMapping
    public ResponseEntity<List<TipoDocumento>> listarTiposDocumento() {
        return new ResponseEntity<>(tipoDocumentoService.findAll(), HttpStatus.OK);
    }

    // Endpoint para obtener un tipo de documento por ID
    @GetMapping("/{id}")
    public ResponseEntity<TipoDocumento> obtenerTipoDocumentoPorId(@PathVariable Integer id) {
        TipoDocumento tipoDocumento = tipoDocumentoService.findById(id);
        if (tipoDocumento != null) {
            return new ResponseEntity<>(tipoDocumento, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint para crear un nuevo tipo de documento
    @PostMapping
    public ResponseEntity<TipoDocumento> crearTipoDocumento(@RequestBody TipoDocumento tipoDocumento) {
        return new ResponseEntity<>(tipoDocumentoService.save(tipoDocumento), HttpStatus.CREATED);
    }

    // Endpoint para actualizar un tipo de documento existente
    @PutMapping("/{id}")
    public ResponseEntity<TipoDocumento> actualizarTipoDocumento(@PathVariable Integer id, @RequestBody TipoDocumento tipoDocumento) {
        TipoDocumento tipoDocExistente = tipoDocumentoService.findById(id);
        if (tipoDocExistente != null) {
            tipoDocumento.setId(id); // Aseguramos que el ID del objeto sea el correcto
            return new ResponseEntity<>(tipoDocumentoService.save(tipoDocumento), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint para eliminar un tipo de documento
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTipoDocumento(@PathVariable Integer id) {
        TipoDocumento tipoDocExistente = tipoDocumentoService.findById(id);
        if (tipoDocExistente != null) {
            tipoDocumentoService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}