package co.edu.uniquindio.unimarket.services;

import java.util.List;

import co.edu.uniquindio.unimarket.models.DetalleCompra;

public interface IDetalleCompraServicio {
	
	public List<DetalleCompra> obtenerTodo();
	
	public DetalleCompra guardarDetalleCompra(DetalleCompra detalleCompra);
	
	public DetalleCompra obtenerPorId(long id);
	
	public void eliminarDetalleCompra(long id);		

}
