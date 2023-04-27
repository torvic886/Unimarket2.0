package co.edu.uniquindio.unimarket.services;

import java.util.List;


import co.edu.uniquindio.unimarket.models.CarritoCompra;

public interface ICarritoCompraServicio {

	public List<CarritoCompra> obtenerTodo();
	
	public CarritoCompra guardarCarritoCompra(CarritoCompra carritoCompra);
	
	public CarritoCompra obtenerPorId(long id);
	
	public void eliminarCarritoCompra(long id);		
}
