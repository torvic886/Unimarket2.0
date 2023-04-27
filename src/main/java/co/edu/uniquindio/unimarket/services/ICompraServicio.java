package co.edu.uniquindio.unimarket.services;

import java.util.List;

import co.edu.uniquindio.unimarket.models.Compra;

public interface ICompraServicio {

	public List<Compra> obtenerTodo();
	
	public Compra guardarCompra(Compra compra);
	
	public Compra obtenerPorId(long id);
	
	public void eliminarCompra(long id);		
}
