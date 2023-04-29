package co.edu.uniquindio.unimarket.services;

import java.util.List;

import co.edu.uniquindio.unimarket.models.Usuario;


public interface IUsuarioServicio {
	
	public List<Usuario> obtenerTodo();
	
	public Usuario guardarUsuario(Usuario usuario);
	
	public Usuario obtenerPorId(long id);
	
	public void eliminarUsuario(long id);	

}
