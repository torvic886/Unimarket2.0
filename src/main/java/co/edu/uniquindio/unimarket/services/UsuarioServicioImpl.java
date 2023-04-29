package co.edu.uniquindio.unimarket.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniquindio.unimarket.models.Usuario;
import co.edu.uniquindio.unimarket.repositories.UsuarioRepositorio;
@Service
public class UsuarioServicioImpl implements IUsuarioServicio {

	@Autowired
	UsuarioRepositorio usuariorepositorio;
	
	@Override
	public List<Usuario> obtenerTodo() {
		return usuariorepositorio.findAll();
	}

	@Override
	public Usuario guardarUsuario(Usuario usuario) {
		return usuariorepositorio.save(usuario);
	}

	@Override
	public Usuario obtenerPorId(long id) {
		return usuariorepositorio.findById(id).orElse(null);
	}

	@Override
	public void eliminarUsuario(long id) {
		usuariorepositorio.deleteById(id);
	}

}
