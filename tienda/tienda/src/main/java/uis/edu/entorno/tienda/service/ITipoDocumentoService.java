package uis.edu.entorno.tienda.service;

import uis.edu.entorno.tienda.entity.TipoDocumento;
import java.util.List;

public interface ITipoDocumentoService {

    public List<TipoDocumento> findAll(); // Devuelve todos los tipos de documento

    public TipoDocumento findById(Integer id); // Devuelve un tipo de documento por su ID

    public TipoDocumento save(TipoDocumento tipoDocumento); // Guarda o actualiza un tipo de documento

    public void delete(Integer id); // Elimina un tipo de documento por su ID
}