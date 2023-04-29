package co.edu.uniquindio.unimarket.services;

import java.util.List;

import co.edu.uniquindio.unimarket.models.Producto;


public interface IProductoServicio {
	
	public List<Producto> obtenerTodo();
	
	public Producto guardarProducto(Producto producto);
	
	public Producto obtenerPorId(long id);
	
	public void eliminarProducto(long id);		

}
