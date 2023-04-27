package co.edu.uniquindio.unimarket.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import co.edu.uniquindio.unimarket.models.DetalleCompra;
import co.edu.uniquindio.unimarket.repositories.DetalleCompraRepositorio;

@Service
public class DetalleCompraServicioImpl implements IDetalleCompraServicio{
	
	@Autowired
	DetalleCompraRepositorio detalleCompraRepositorio;
	
	@Override
	public List<DetalleCompra> obtenerTodo() {
		return detalleCompraRepositorio.findAll();
	}

	@Override
	public DetalleCompra guardarDetalleCompra(DetalleCompra detalleCompra) {
		return detalleCompraRepositorio.save(detalleCompra);
	}

	@Override
	public DetalleCompra obtenerPorId(long id) {
		return detalleCompraRepositorio.findById(id).orElse(null);
	}

	@Override
	public void eliminarDetalleCompra(long id) {
		detalleCompraRepositorio.deleteById(id);
		
	}

}
