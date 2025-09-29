package uis.edu.entorno.tienda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uis.edu.entorno.tienda.entity.Usuario;
import uis.edu.entorno.tienda.repository.UsuarioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> cargarUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario buscarPorId(Integer id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public Usuario agregar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario editar(Integer id, Usuario usuario) {
        // Primero, buscamos si el usuario existe en la base de datos
        Optional<Usuario> usuarioExistenteOptional = usuarioRepository.findById(id);

        // Si existe, lo actualizamos. Si no, devolvemos null.
        if (usuarioExistenteOptional.isPresent()) {
            // Asignamos el ID al objeto usuario que nos llega para asegurar que estamos actualizando
            // el registro correcto.
            usuario.setId(id);
            return usuarioRepository.save(usuario);
        } else {
            return null; // O podríamos lanzar una excepción de "No encontrado"
        }
    }

    @Override
    public void eliminar(Integer id) {
        usuarioRepository.deleteById(id);
    }
}