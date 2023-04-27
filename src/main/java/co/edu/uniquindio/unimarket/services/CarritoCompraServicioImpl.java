package co.edu.uniquindio.unimarket.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniquindio.unimarket.models.CarritoCompra;
import co.edu.uniquindio.unimarket.repositories.CarritoCompraRepositorio;


@Service
public class CarritoCompraServicioImpl implements ICarritoCompraServicio {

	
	@Autowired
	CarritoCompraRepositorio carritoCompraRepositorio;	
	
	@Override
	public List<CarritoCompra> obtenerTodo() {
		return carritoCompraRepositorio.findAll();
	}

	@Override
	public CarritoCompra guardarCarritoCompra(CarritoCompra carritoCompra) {
		return carritoCompraRepositorio.save(carritoCompra);
	}

	@Override
	public CarritoCompra obtenerPorId(long id) {
		return carritoCompraRepositorio.findById(id).orElse(null);
	}

	@Override
	public void eliminarCarritoCompra(long id) {
		carritoCompraRepositorio.deleteById(id);
		
	}

}
