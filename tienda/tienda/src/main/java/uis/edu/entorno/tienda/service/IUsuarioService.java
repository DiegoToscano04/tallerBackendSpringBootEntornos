package uis.edu.entorno.tienda.service;

import uis.edu.entorno.tienda.entity.Usuario;
import java.util.List;

public interface IUsuarioService {

    // Metodo para listar todos los usuarios (cargarUsuarios)
    List<Usuario> cargarUsuarios();

    // Metodo para buscar un usuario por su ID
    Usuario buscarPorId(Integer id);

    // Metodo para agregar un nuevo usuario
    Usuario agregar(Usuario usuario);

    // Metodo para actualizar un usuario existente
    Usuario editar(Integer id, Usuario usuario);

    // Metodo para eliminar un usuario por su ID
    void eliminar(Integer id);

}