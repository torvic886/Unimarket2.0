package co.edu.uniquindio.unimarket.services;

import java.util.List;

import co.edu.uniquindio.unimarket.models.Autorizacion;

public interface IAutorizacionServicio {
	
	public List<Autorizacion> obtenerTodo();
	
	public Autorizacion guardarAutorizacion(Autorizacion autorizacion);
	
	public Autorizacion obtenerPorId(long id);
	
	public void eliminarAutorizacion(long id);		

}
