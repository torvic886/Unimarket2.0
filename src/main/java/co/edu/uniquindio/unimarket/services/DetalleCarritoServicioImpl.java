package co.edu.uniquindio.unimarket.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniquindio.unimarket.models.DetalleCarrito;
import co.edu.uniquindio.unimarket.repositories.DetalleCarritoRepositorio;

@Service
public class DetalleCarritoServicioImpl implements IDetalleCarritoServicio{

	
	@Autowired
	DetalleCarritoRepositorio detalleCarritoRepositorio;
	
	@Override
	public List<DetalleCarrito> obtenerTodo() {
		return detalleCarritoRepositorio.findAll();
	}

	@Override
	public DetalleCarrito guardarDetalleCarrito(DetalleCarrito detalleCarrito) {
		return detalleCarritoRepositorio.save(detalleCarrito);
	}

	@Override
	public DetalleCarrito obtenerPorId(long id) {
		return detalleCarritoRepositorio.findById(id).orElse(null);

	}

	@Override
	public void eliminarDetalleCarrito(long id) {
		detalleCarritoRepositorio.deleteById(id);
		
	}

}
