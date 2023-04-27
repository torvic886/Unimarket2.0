package co.edu.uniquindio.unimarket.services;

import java.util.List;

import co.edu.uniquindio.unimarket.models.Moderador;

public interface IModeradorServicio {
	
	public List<Moderador> obtenerTodo();
	
	public Moderador guardarModerador(Moderador moderador);
	
	public Moderador obtenerPorId(long id);
	
	public void eliminarModerador(long id);	

}
