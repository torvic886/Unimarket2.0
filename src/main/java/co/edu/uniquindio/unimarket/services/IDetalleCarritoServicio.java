package co.edu.uniquindio.unimarket.services;

import java.util.List;


import co.edu.uniquindio.unimarket.models.DetalleCarrito;

public interface IDetalleCarritoServicio {

	public List<DetalleCarrito> obtenerTodo();
	
	public DetalleCarrito guardarDetalleCarrito(DetalleCarrito detalleCarrito);
	
	public DetalleCarrito obtenerPorId(long id);
	
	public void eliminarDetalleCarrito(long id);	
}
