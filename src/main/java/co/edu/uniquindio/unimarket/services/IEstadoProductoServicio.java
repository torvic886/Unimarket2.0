package co.edu.uniquindio.unimarket.services;

import java.util.List;

import co.edu.uniquindio.unimarket.models.EstadoProducto;


public interface IEstadoProductoServicio {
	
	public List<EstadoProducto> obtenerTodo();
	
	public EstadoProducto guardarEstadoProducto(EstadoProducto estadoProducto);
	
	public EstadoProducto obtenerPorId(long id);
	
	public void eliminarEstadoProducto(long id);	
	

}
